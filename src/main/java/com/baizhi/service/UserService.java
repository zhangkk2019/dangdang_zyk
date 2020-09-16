package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.entity.User;

public interface UserService {
	// 登录
	public void login(User user);
	
	//查所有用户
	public List<User> selectAllUser();
	
	// 查询一级类别 分类浏览
	public List<Category> selectAllFirst();

	// 随机找书 编辑推荐
	public List<Book> selectRandom();

	// 按销量查询 热销榜
	public List<Book> selectBySale();

	// 按上架时间查询 最新上架图书
	public List<Book> selectByCreateDate();

	// 按上架时间和销量查询
	public List<Book> selectByCreateDateAndSale();
	
	//跳转二级页面
	public List<Book> selectSecondPage(String fid,String sid,Integer begin,Integer end);
	
	//查询分页总量
	public Integer selectCount(String fid,String sid,Integer pageSize);
	
	//查询一个一级类别
	public Category selectOneFirst(String fid);
	
	//注册
	public void regist(User user,String code);
	
	//更新       激活码
	public void activeUser(String activeCode);
	
	// 更新 修改状态
	public void activeUser2(User user);
	
	//查一个人
	public User selectOneUserById(String id);
	
	//查询一本书
	public Book selectOneBook(Integer bookid);
}
