package com.baizhi.test;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Category;
import com.baizhi.service.AdminService;
import com.baizhi.service.impl.AdminServiceImpl;
import com.baizhi.util.MybatisUtil;

public class AdminTest {
	/*
	@Test
	public void testSelectAllCategory(){
		AdminDao dao = (AdminDao)MybatisUtil.getMapper(AdminDao.class);
		Admin admin = dao.login("admin");
		System.out.println(admin);
		//
		
		System.out.println("查询所有类别：");
		AdminService service = new AdminServiceImpl();
		List<Category> ca = service.selectAllCategory();
		for(Category c : ca){
			System.out.println(c);
		}
	}*/
	@Test
	public void testMybatisUtil(){
		SqlSession sqlSession = MybatisUtil.openSession();
		Connection con = sqlSession.getConnection();
		System.out.println(con);
	}
	
}
