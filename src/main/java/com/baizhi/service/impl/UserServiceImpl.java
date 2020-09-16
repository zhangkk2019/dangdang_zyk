package com.baizhi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.common.Constants;
import com.baizhi.dao.AdminDao;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.MD5Utils;
import com.baizhi.util.MybatisUtil;
public class UserServiceImpl implements UserService {

	// 登录
	public void login(User user) {
		try {
			// 获取UserDao
			UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
			// 判断当前用户名输入是否正确
			User u = dao.login(user.getEmail());
			if (u == null)
				throw new RuntimeException("用户名输入错误");
			// 判断密码输入是否正确
			else if (!u.getPassword().equals(user.getPassword())) {
				throw new RuntimeException("密码输入错误");
			} else if(!u.getStatus().equals("正常")){
				throw new RuntimeException("被封印");
			}else{

				HttpSession session = ServletActionContext.getRequest()
						.getSession();
				session.setAttribute("user", u);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			MybatisUtil.close();
		}
	}

	// 查询一级类别 分类浏览
	public List<Category> selectAllFirst() {
		UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
		List<Category> categoryList = dao.selectAllFirst();
		MybatisUtil.close();
		return categoryList;
	}

	// 随机找书 编辑推荐
	public List<Book> selectRandom() {
		AdminDao dao = (AdminDao) MybatisUtil.getMapper(AdminDao.class);
		List<Book> list = dao.selectAllBook();
		Integer a = new Random().nextInt(list.size());
		Integer b = new Random().nextInt(list.size());
		while (true) {
			if (a == b) {
				b = new Random().nextInt(list.size());
			} else {
				break;
			}
		}
		List<Book> bookList = new ArrayList<Book>();
		bookList.add(list.get(a));
		bookList.add(list.get(b));

		MybatisUtil.close();
		return bookList;
	}

	// 热销图书
	public List<Book> selectBySale() {
		UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
		List<Book> bookList = dao.selectBySale();
		MybatisUtil.close();
		return bookList;
	}

	// 按上架时间查询 最新上架图书
	public List<Book> selectByCreateDate() {
		UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
		List<Book> bookList = dao.selectByCreateDate();
		MybatisUtil.close();
		return bookList;
	}

	// 按上架时间和销量查询
	public List<Book> selectByCreateDateAndSale() {
		UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
		List<Book> bookList = dao.selectByCreateDateAndSale();
		MybatisUtil.close();
		return bookList;
	}
	
	//跳转二级页面
	public List<Book> selectSecondPage(String fid,String sid,Integer pageNum,Integer pageSize){
		UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
		Integer begin = (pageNum-1)*pageSize+1;
		Integer end = pageNum*pageSize;
		
		List<Book> bookList = dao.selectSecondPage(fid,sid,begin,end);
		MybatisUtil.close();
		return bookList;
	}
	
	//查询分页总量
	public Integer selectCount(String fid,String sid,Integer pageSize){
		UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
		Integer count = dao.selectCount(fid,sid);
		Integer total = (count%pageSize==0)?(count/pageSize):(count/pageSize+1);
		MybatisUtil.close();
		return total;
	}
	
	//查询一个一级类别
	public Category selectOneFirst(String fid){
		UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
		Category category = dao.selectOneFirst(fid);
		MybatisUtil.close();
		return category;
	}
	
	//注册
	public void regist(User user,String code){//这里的code为输入的验证码
		//获取UserDao  session
		UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
		HttpSession session = ServletActionContext.getRequest().getSession();
		String code1 = (String) session
				.getAttribute(Constants.SECURITYCODE);
		//System.out.println(code1);
		//System.out.println("service里从useracton传过来的验证码"+code);
		if(!code1.equals(code)) throw new RuntimeException("验证码输入错误");
		User user1 = dao.selectOneUser(user.getEmail());
		//System.out.println("原有的？"+user1);
		//System.out.println("现在的（从action传过来的）"+user);
		if(user1!=null)throw new RuntimeException("该邮箱已被注册");
		//若没有被注册
		
		try{
			user.setId(UUID.randomUUID().toString());
			user.setSalt("正常");
			String salt=MD5Utils.getSalt();
			String password=MD5Utils.getPassword(user.getPassword()+salt);
			//user.setPassword(password);
			user.setSalt(salt);
			user.setStatus("正常");
			user.setCreate_date(new Date());
			dao.regist(user);
			//System.out.println("现在的赋值过的）"+user);
			session.setAttribute("loginUser", user);
			session.setAttribute("user", user);
			User user2 = (User)session.getAttribute("loginUser");
			//System.out.println("注册后存入session的loginUser"+(User)session.getAttribute("loginUser"));
			MybatisUtil.commit();
		}catch(Exception e){
			MybatisUtil.rollback();
			e.printStackTrace();
			MybatisUtil.rollback();
		}
	}
	
	//更新激活码
	public void activeUser(String activeCode2){//activeCode为输入的激活码
		//获取UserDao  session
		UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
		HttpSession session = ServletActionContext.getRequest().getSession();
		String code=(String)session.getAttribute("active");//这是生成的激活码
		User user = (User)session.getAttribute("loginUser");
		if(!code.equals(activeCode2)) throw new RuntimeException("激活码输入错误");
		try{
			user.setCode(activeCode2);
			dao.activeUser(user);
			session.setAttribute("loginUser", user);
			MybatisUtil.commit();
		}catch(Exception e){
			MybatisUtil.rollback();
			e.printStackTrace();
		}
		
	}
	// 更新 修改状态
	public void activeUser2(User user){
		UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
		dao.activeUser2(user);
		MybatisUtil.commit();
	}
	
	//根据id查一个人
	public User selectOneUserById(String id) {
		// TODO Auto-generated method stub
		UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
		User user = dao.selectOneUserById(id);
		return user;
	}
	
	//查询一本书
	public Book selectOneBook(Integer bookid){
		UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
		Book book = dao.selectOneBook(bookid);
		return book;
	}

	@Override
	public List<User> selectAllUser() {
		UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
		List<User> userList=null;
		try{
			userList = dao.selectAllUser();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return userList;
	}
	
}
