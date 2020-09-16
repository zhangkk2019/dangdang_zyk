package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.entity.User;

public interface AdminService {
	// 登录
	public void login(Admin admin);

	
	// 查询所有分类
	public List<Category> selectAllCategory();

	// 查询所有分类 跳转二级添加时使用
	public List<Category> selectCategory();

	// 添加一级类别
	public void addFirst(Category category);

	// 查询子类
	public List<Category> selectSons(String id);

	// 删除
	public void deleteCategory(String id);

	// 添加二级类别
	public void addSecond(Category category);
	
	//查一个一级类别
	public Category selectOneCategory(String id);

	// 查询所有书籍
	public List<Book> selectAllBook();

	// 删除书籍
	public void deleteBook(String id);

	// 模糊查询
	public List<Book> selectByKey(String key, String content);

	// 查询一本书
	public Book selectOneBook(Integer id);

	// 查询所有二级类别
	public List<Category> selectAllSecond();

	// 更新
	public void updateOneBook(Book book);
	
	//添加书籍
	public void addBook(Book book);
}
