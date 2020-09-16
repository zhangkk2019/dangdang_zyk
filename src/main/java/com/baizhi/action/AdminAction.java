package com.baizhi.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.baizhi.common.Constants;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.entity.User;
import com.baizhi.service.AdminService;
import com.baizhi.service.UserService;
import com.baizhi.service.impl.AdminServiceImpl;
import com.baizhi.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.Action;

//对于action层  只做三件事 ：1，收参传参      2，调用service    3，进行跳转
public class AdminAction {
	private Admin admin;
	private String message;// 用来传递参数
	private String captchaCode;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCaptchaCode() {
		return captchaCode;
	}

	public void setCaptchaCode(String captchaCode) {
		this.captchaCode = captchaCode;
	}
	
	//id
		private String id;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
	// 登录
	public String login() {
		AdminService service = new AdminServiceImpl();
		try {
			service.login(admin);

			/*
			 * 验证码验证： 1.从session作用域取出服务器端的验证码随机数 2.与客户端提交的比较
			 */
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			String securityCode = (String) session
					.getAttribute(Constants.SECURITYCODE);

			if (securityCode.equalsIgnoreCase(captchaCode)) {
				System.out.println("action 验证码："
						+ securityCode.equalsIgnoreCase(captchaCode));
				return Action.SUCCESS;
			} else
				return Action.ERROR;

		} catch (Exception e) {
			message = e.getMessage();
			return Action.ERROR;
		}
	}

	// 退出
	 public String logout(){
		 HttpSession session = ServletActionContext.getRequest().getSession();
		 session.removeAttribute("admin");
		 return "logout";
	}
	
	private List<User> userList;
	//查询所有用户
	public String selectAllUser(){
		UserService service = new UserServiceImpl();
		userList = service.selectAllUser();
		return "selectAllUser";
	}
	
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	// Category集合
	private List<Category> categoryList;

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	// 展示所有类别
	public String selectAllCategory() {
		AdminService service = new AdminServiceImpl();
		categoryList = service.selectAllCategory();
		return "selectAllCategory";
	}

	// Category对象
	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	//fCategory对象
	private Category fCategory;
	
	public Category getfCategory() {
		return fCategory;
	}

	public void setfCategory(Category fCategory) {
		this.fCategory = fCategory;
	}

	// 添加一级类别
	public String addFirst() {
		AdminService service = new AdminServiceImpl();
		service.addFirst(category);
		return "addFirst";
	}
	
	//添加二级类别
	public String addSecond() {
		AdminService service = new AdminServiceImpl();
		System.out.println(category);
		service.addSecond(category);
		
		return "addSecond";
	}

	// 查询所有类别   跳转二级添加时使用
	public String selectCategory() {
		AdminService service = new AdminServiceImpl();
		categoryList = service.selectCategory();
		return "selectCategory";
	}
	
	
	
	//刪除
	public String deleteCategory(){
		AdminService service = new AdminServiceImpl();
		service.deleteCategory(id);
		return "deleteCategory";
	}
	
	//书集合
	private List<Book> bookList;

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
	//查询所有书籍
	public String selectAllBook(){
		AdminService service = new AdminServiceImpl();
		bookList = service.selectAllBook();
		return "selectAllBook";
	}
	
	//删除书籍
	public String deleteBook(){
		AdminService service = new AdminServiceImpl();
		service.deleteBook(id);
		return "deleteBook";
	}
	
	//key  content
	private String key;
	private String content;
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	//模糊查询
	public String selectByKey(){
		AdminService service = new AdminServiceImpl();
		bookList = service.selectByKey(key, content);
		return "selectByKey";
	}
	
	//book
	private Book book;
	
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

	//查询一本书
	public String selectOneBook(){
		AdminService service = new AdminServiceImpl();
		book = service.selectOneBook(bookId);
		categoryList = service.selectAllSecond();
		return "selectOneBook";
	}
	
	//查询二级类别
	public String selectAllSecond(){
		AdminService service = new AdminServiceImpl();
		categoryList = service.selectAllSecond();
		return "selectAllSecond";
	}
	
	
	//当前图片
	private File cover;
	//文件名
	private String coverFileName;
	//文件类型
	private String coverContentType;
	
	public File getCover() {
		return cover;
	}

	public void setCover(File cover) {
		this.cover = cover;
	}

	public String getCoverFileName() {
		return coverFileName;
	}

	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}

	public String getCoverContentType() {
		return coverContentType;
	}

	public void setCoverContentType(String coverContentType) {
		this.coverContentType = coverContentType;
	}
	
	//更新 书
	public String updateOneBook(){
		AdminService service = new AdminServiceImpl();
		//判断当前封面是否进行了修改
		if(coverFileName!=null){//如果已修改
			//封面上传
			//1，通过相对路径获取绝对路径
			String path = ServletActionContext.getServletContext().getRealPath("/back/img");
			//2通过工具类进行文件拷贝
			try {
				FileUtils.copyFile(new File(path+"//"+coverFileName),cover);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			book.setCover(coverFileName);
		}
		service.updateOneBook(book);
		return "updateOneBook";
	}
	
	
	//添加书籍
	public String addBook(){
		AdminService service = new AdminServiceImpl();
			//文件保存
			//1.通过相对路径获取绝对路径
			String path = ServletActionContext.getServletContext().getRealPath("/back/img");
			//2.调用工具类，进行文件拷贝
			try {
				FileUtils.copyFile(cover,new File(path,coverFileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			book.setCover(coverFileName);
		service.addBook(book);
		return "addBook";
	}
	
}
