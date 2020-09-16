package com.baizhi.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
public interface AdminDao {
	/**
	 * 这是后台管理员登陆
	 * @param username 管理员用户名
	 * @return 查询出的管理员数据
	 */
	public Admin login(
			@Param("username")String username
		);
	//查询所有分类
	public List<Category> selectAllCategory();
	
	//查询类别  跳转二级类别添加时使用
	public List<Category> selectCategory(); 
	//添加一级类别
	public void addFirst(Category category);
	
	//查询子类
	public List<Category> selectSons(String id);
	
	//删除
	public void deleteCategory(String id);
	
	//添加二级类别
	public void addSecond(Category category);
	
	//查询所有书籍
	public List<Book> selectAllBook();
	
	//查一个一级类别
	public Category selectOneCategory(String id);
	
	//删除书籍
	public void deleteBook(String id);
	
	//模糊查询
	public List<Book> selectByKey(
			@Param("key")String key,
			@Param("content")String content
		);
	
	//查询一本书
	public Book selectOneBook(Integer id);
	
	//查询所有二级类别
	public List<Category> selectAllSecond();
	
	//更新
	public void updateOneBook(Book book);
	
	//添加书籍
	public void addBook(Book book);
}
