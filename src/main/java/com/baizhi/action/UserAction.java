package com.baizhi.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.entity.User;
import com.baizhi.service.AdminService;
import com.baizhi.service.UserService;
import com.baizhi.service.impl.AdminServiceImpl;
import com.baizhi.service.impl.UserServiceImpl;
import com.baizhi.util.MD5Utils;
import com.opensymphony.xwork2.Action;

//对于action层  只做三件事 ：1，收参传参      2，调用service    3，进行跳转
public class UserAction {
	private User user;
	private String message;// 用来传递参数

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// 登录
	public String login() {
		UserService service = new UserServiceImpl();

		try {
			service.login(user);
			return Action.SUCCESS;

		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
			return Action.ERROR;
		}
		/*
		 * service.login(user); return Action.SUCCESS;
		 */
	}

	// 退出
	public String loginOut() {

		// 获取session对象
		HttpSession session = ServletActionContext.getRequest()
				.getSession();
		// 删除session中的命名属性
		session.removeAttribute("user");
		// 销毁session
		 //session.invalidate();
		// 跳转到登录页
		return "loginOut";

	}

	private Category category;
	private List<Category> categoryList;
	private List<Book> books;
	private List<Book> hotBook;
	private List<Book> newBook;
	private List<Book> newHotBook;

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public List<Book> getHotBook() {
		return hotBook;
	}

	public void setHotBook(List<Book> hotBook) {
		this.hotBook = hotBook;
	}

	public List<Book> getNewBook() {
		return newBook;
	}

	public void setNewBook(List<Book> newBook) {
		this.newBook = newBook;
	}

	public List<Book> getNewHotBook() {
		return newHotBook;
	}

	public void setNewHotBook(List<Book> newHotBook) {
		this.newHotBook = newHotBook;
	}

	// 首页
	public String main() {
		UserService service = new UserServiceImpl();
		// 1,分类浏览
		categoryList = service.selectAllFirst();
		// 2,编辑推荐
		books = service.selectRandom();
		// 3,热销图书
		hotBook = service.selectBySale();
		// 4,最新上架图书
		newBook = service.selectByCreateDate();
		// 5,新书热卖榜
		newHotBook = service.selectByCreateDateAndSale();

		return "main";
	}

	// fid,sid
	private String fid;
	private String sid;
	// 当前页面
	private Integer pageNum = 1;
	// 每页展示条数
	private Integer pageSize = 4;
	// 页数总量
	private Integer total;

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	// 二级页面
	public String selectSecondPage() {
		try {
			UserService service = new UserServiceImpl();
			// System.out.print(sid+"   " +fid+"    ");
			// 分类浏览需要的数据
			category = service.selectOneFirst(fid);
			// 书籍
			books = service.selectSecondPage(fid, sid, pageNum, pageSize);
			// 页数总量
			total = service.selectCount(fid, sid, pageSize);
			// System.out.println("total");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "selectSecondPage";
	}

	private Book book;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	private Integer bookId;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	// 查一本书
	public String selectOneBook() {
		AdminService service = new AdminServiceImpl();
		book = service.selectOneBook(bookId);
		return "selectOneBook";
	}

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	// 注册
	public String regist() {
		// 获取
		UserService service = new UserServiceImpl();
		try {
			System.out.println("useraction获取到的" + user);
			System.out.println("useraction获取到的验证码" + code);
			service.regist(user, code);
		} catch (Exception e) {
			message = e.getMessage();
			e.printStackTrace();
			return "error";
		}
		return "regist";
	}

	private String activeCode;

	public String getActiveCode() {
		return activeCode;
	}

	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}

	private User loginUser;

	public User getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}

	private String activeCode2;

	public String getActiveCode2() {
		return activeCode2;
	}

	public void setActiveCode2(String activeCode2) {
		this.activeCode2 = activeCode2;
	}

	// 获取激活码
	public String getAcCode() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		try {
			activeCode = MD5Utils.getNum();
			session.setAttribute("active", activeCode);
			System.out.println("获取激活码的action能拿到loginuser吗"
					+ session.getAttribute("loginUser"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "getAcCode";
	}

	// 完成注册  更新激活码
	public String activeUser() {
		UserService service = new UserServiceImpl();
		try {
			service.activeUser(activeCode2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "activeUser";
	}
	
	public String activeUser2(){
		UserService service = new UserServiceImpl();
		try {
			user = service.selectOneUserById(id);
			service.activeUser2(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "activeUser2";
	}
	
}
