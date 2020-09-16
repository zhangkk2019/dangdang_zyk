package com.baizhi.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Admin;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
public class test2 extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {//前台在结算后需要拦截
		//既能拦截未登录用户，也能拦截未激活用户
		HttpSession session= ServletActionContext.getRequest().getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin==null){
			return "loginError";
		}else{
			arg0.invoke();//表示当前程序继续往前走
		}
		return "success";
	}

}
