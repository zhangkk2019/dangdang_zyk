package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.entity.User;

public interface UserDao {

	// 登录
	public User login(String email);

	// 查所有用户
	public List<User> selectAllUser();

	// 查询一级类别 分类浏览
	public List<Category> selectAllFirst();

	// 按销量查询 热销榜
	public List<Book> selectBySale();

	// 按上架时间查询 最新上架图书
	public List<Book> selectByCreateDate();

	// 按上架时间和销量查询
	public List<Book> selectByCreateDateAndSale();

	// 跳转二级页面
	public List<Book> selectSecondPage(@Param("fid") String fid,
			@Param("sid") String sid, @Param("begin") Integer begin,
			@Param("end") Integer end);

	// 查询分页总量
	public Integer selectCount(@Param("fid") String fid,
			@Param("sid") String sid);

	// 查询一个一级类别
	public Category selectOneFirst(String fid);

	// 根据邮箱查用户
	public User selectOneUser(String email);

	// 用户注册
	public void regist(User user);

	// 更新 激活码
	public void activeUser(User user);

	// 更新 修改状态
	public void activeUser2(User user);

	// 根据id查user
	public User selectOneUserById(String id);

	// 更新书籍
	public void updateBook(Book book);

	// 查询一本书
	public Book selectOneBook(Integer bookid);
}
