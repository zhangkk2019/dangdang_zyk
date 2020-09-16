package com.baizhi.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.AdminService;
import com.baizhi.util.MybatisUtil;

public class AdminServiceImpl implements AdminService {
	// 对于action层 只做三件事 ：1，收参传参 2，调用service 3，进行跳转
	// 登录
	@Override
	public void login(Admin admin) {
		try {
			// 获取AdminDao
			AdminDao dao = (AdminDao) MybatisUtil.getMapper(AdminDao.class);
			// 判断当前用户名输入是否正确
			Admin a = dao.login(admin.getUsername());
			if (a == null)
				throw new RuntimeException("用户名输入错误");
			// 判断密码输入是否正确
			else if (!a.getPassword().equals(admin.getPassword()))
				throw new RuntimeException("密码输入错误");

			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			session.setAttribute("admin", a);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			MybatisUtil.close();
		}
	}

	// 查询所有分类
	@Override
	public List<Category> selectAllCategory() {
		// TODO Auto-generated method stub
		List<Category> categoryList = null;
		try {
			// 获取AdminDao
			AdminDao dao = (AdminDao) MybatisUtil.getMapper(AdminDao.class);
			// 获取所有分类
			categoryList = dao.selectAllCategory();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			MybatisUtil.close();
		}
		return categoryList;
	}

	// 查询一级类别
	public List<Category> selectCategory() {
		// TODO Auto-generated method stub
		List<Category> categoryList = null;
		try {
			// 获取AdminDao
			AdminDao dao = (AdminDao) MybatisUtil.getMapper(AdminDao.class);
			// 获取所有分类
			categoryList = dao.selectCategory();
			/*
			 * List<Category> list = dao.selectCategory(); for(Category category
			 * : list){ System.out.println();
			 * if(category.getLevels().equals("1")){
			 * System.out.println(category.getLevels().equals("1"));
			 * categoryList.add(category); }else{ continue; } }
			 */
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			MybatisUtil.close();
		}
		return categoryList;
	}

	// 添加一级类别
	public void addFirst(Category category) {
		try {
			// 获取AdminDao
			AdminDao dao = (AdminDao) MybatisUtil.getMapper(AdminDao.class);
			// 添加
			category.setId(UUID.randomUUID().toString());// 设置uuid
			category.setLevels("1");
			// category.setParentId(null);
			dao.addFirst(category);
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
			throw new RuntimeException(e.getMessage());

		} finally {
			MybatisUtil.close();
		}
	}

	// 查询子类
	public List<Category> selectSons(String id) {
		List<Category> categoryList = null;
		try {
			// 获取AdminDao
			AdminDao dao = (AdminDao) MybatisUtil.getMapper(AdminDao.class);
			// 获取所有分类
			categoryList = dao.selectSons(id);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			MybatisUtil.close();
		}
		return categoryList;
	}

	// 删除类别
	public void deleteCategory(String id) {
		try {
			// 获取AdminDao
			AdminDao dao = (AdminDao) MybatisUtil.getMapper(AdminDao.class);
			List<Category> list = dao.selectSons(id);
			if (list.size() == 0) {
				dao.deleteCategory(id);
			}
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
			throw new RuntimeException(e.getMessage());

		} finally {
			MybatisUtil.close();
		}
	}

	// 添加二级类别
	public void addSecond(Category category) {
		try {
			// 获取AdminDao
			AdminDao dao = (AdminDao) MybatisUtil.getMapper(AdminDao.class);
			// 添加
			category.setId(UUID.randomUUID().toString());// 设置uuid
			category.setLevels("2");
			//category.setParentId();
			dao.addSecond(category);
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
			throw new RuntimeException(e.getMessage());

		} finally {
			MybatisUtil.close();
		}
	}
	
	//查一个一级类别
	public Category selectOneCategory(String id){
		Category category = null;
		try {
			// 获取AdminDao
			AdminDao dao = (AdminDao) MybatisUtil.getMapper(AdminDao.class);
			// 获取所有分类
			category = dao.selectOneCategory(id);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			MybatisUtil.close();
		}
		return category;
	}
	
	// 查询所有书籍
	public List<Book> selectAllBook() {
		List<Book> bookList = null;
		try {
			// 获取AdminDao
			AdminDao dao = (AdminDao) MybatisUtil.getMapper(AdminDao.class);
			// 获取所有分类
			bookList = dao.selectAllBook();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			MybatisUtil.close();
		}
		return bookList;
	}

	// 删除书籍
	public void deleteBook(String id) {
		try {
			// 获取AdminDao
			AdminDao dao = (AdminDao) MybatisUtil.getMapper(AdminDao.class);
			dao.deleteBook(id);
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
			throw new RuntimeException(e.getMessage());

		} finally {
			MybatisUtil.close();
		}
	}

	// 模糊查询
	public List<Book> selectByKey(String key, String content) {
		List<Book> bookList = null;
		try {
			// 获取AdminDao
			AdminDao dao = (AdminDao) MybatisUtil.getMapper(AdminDao.class);
			// 获取所有分类
			bookList = dao.selectByKey(key, content);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			MybatisUtil.close();
		}
		return bookList;
	}

	// 查询一本书
	public Book selectOneBook(Integer id) {
		Book book = null;
		try {
			// 获取AdminDao
			AdminDao dao = (AdminDao) MybatisUtil.getMapper(AdminDao.class);
			// 获取所有分类
			book = dao.selectOneBook(id);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			MybatisUtil.close();
		}
		return book;
	}

	// 查询所有二级类别
	public List<Category> selectAllSecond() {
		List<Category> categoryList = null;
		try {
			// 获取AdminDao
			AdminDao dao = (AdminDao) MybatisUtil.getMapper(AdminDao.class);
			// 获取所有分类
			categoryList = dao.selectAllSecond();

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			MybatisUtil.close();
		}
		return categoryList;
	}

	// 更新书籍
	public void updateOneBook(Book book) {
		try {
			// 获取AdminDao
			AdminDao dao = (AdminDao) MybatisUtil.getMapper(AdminDao.class);
			//System.out.println(book);
			dao.updateOneBook(book);
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
			throw new RuntimeException(e.getMessage());

		} finally {
			MybatisUtil.close();
		}
	}
	
	//添加书籍
	public void addBook(Book book){
		try {
			// 获取AdminDao
			AdminDao dao = (AdminDao) MybatisUtil.getMapper(AdminDao.class);
			// 添加
			book.setCreate_date(new Date());
			book.setSale(0);
			dao.addBook(book);
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
			throw new RuntimeException(e.getMessage());

		} finally {
			MybatisUtil.close();
		}
	}
}
