package com.baizhi.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
public class test extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {//前台在结算后需要拦截
		//既能拦截未登录用户，也能拦截未激活用户
		HttpSession session= ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute("user");
		//System.out.println(user);
		if(user==null){
			return "loginError";
		}else{
			if(user.getCode()==null||"".equals(user.getCode())){
				return "activeError";
			}else{
				arg0.invoke();//表示当前程序继续往前走
			}
		}
		session.setAttribute("user", user);
		return null;
	}

}
