package com.baizhi.test;

import org.junit.Test;

import com.baizhi.dao.AdminDao;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.Category;
import com.baizhi.service.UserService;
import com.baizhi.service.impl.UserServiceImpl;
import com.baizhi.util.MybatisUtil;
public class TestUser {
	public static void main(String[] sf){
		
	}
	@Test
	public void testLogin(){
		UserDao dao = (UserDao)MybatisUtil.getMapper(UserDao.class);
		//User user = dao.login("lisi");
		//System.out.println(user);
		
		UserService service = new UserServiceImpl();
		/*
		List<Category> list1 = service.selectAllFirst();
	
		for(Category c : list1){
			System.out.println(c.getName()+"  *********************************************");
			for(Category cc : c.getCateList()){
				System.out.println(cc.getName());
			}
		}
		
		List<Book> list2 = dao.selectByCreateDateAndSale();
		for(Book b : list2){
			System.out.println(b);
			
		}
		System.out.println("结束");
		*/
		  AdminDao adao = (AdminDao)MybatisUtil.getMapper(AdminDao.class); 
		Category category = new Category("sjdfk","二级test9","abf3e146-1ac8-4431-971e-63df4e06ae52","2",null,null);
		adao.addSecond(category);
		MybatisUtil.commit();
		System.out.println("sdhf ");
	}
}
