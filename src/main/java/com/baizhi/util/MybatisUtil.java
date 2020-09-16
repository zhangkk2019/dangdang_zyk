package com.baizhi.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	
	private static SqlSessionFactory factory;
	
	static {//静态代码块，只在类加载的时候执行一次
		// 1.使用Resources读取mybatis-config.xml
		InputStream in= null;
		try {
			in = Resources.getResourceAsStream("mybatis-config.xml");
			// 2.创建SqlSessionFactory
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private static ThreadLocal<SqlSession> tol = new ThreadLocal<SqlSession>();
	// 创建SqlSession并返回
	public static SqlSession openSession(){
		SqlSession sqlSession = tol.get();
		// 3.创建SqlSession
		if(sqlSession == null){
			sqlSession = factory.openSession();
			tol.set(sqlSession);
		}
		return sqlSession;
	}
	
	//获取dao
	public static <T> Object getMapper(Class<T> c){//泛型
		SqlSession sqlSession = openSession();
		T t = sqlSession.getMapper(c);
		return t;
	}
	
	//提交事务
	public static void commit(){
		SqlSession sqlSession = openSession();
		sqlSession.commit();
	}
	//回滚事务
	public static void rollback(){
		SqlSession sqlSession = openSession();
		sqlSession.rollback();
	}
	// 释放资源
	public static void close() {
		SqlSession sqlSession = openSession();
		if(sqlSession != null){
			sqlSession.close();
			//从当前线程移除
			tol.remove();
		}
	}
}
