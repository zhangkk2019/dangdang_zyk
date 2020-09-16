package com.baizhi.action;

import java.awt.image.BufferedImage;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.baizhi.common.Constants;
import com.baizhi.util.SecurityCode;
import com.baizhi.util.SecurityImage;
import com.opensymphony.xwork2.ActionSupport;

public class CaptchaAction extends ActionSupport {
	public String execute() throws Exception{
		//1,获取验证码随机数
		String securityCode = SecurityCode.getSecurityCode();
		//2，将验证码随机数存入session作用域
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute(Constants.SECURITYCODE, securityCode);
		
		//3,创建验证码图片
		BufferedImage image = SecurityImage.createImage(securityCode);
		//4,使用IO六响应验证码图片到客户端
		HttpServletResponse response = ServletActionContext.getResponse();
		OutputStream out = response.getOutputStream();
		/*
		 * 参数一：指定响应的验证码图片对象
		 * 参数二：指定图片的格式
		 * 参数三：指定响应结果的输出流对象
		 * */
		ImageIO.write(image, "png", out);
		return null;//这里不做跳转，因为使用流响应结果
	}
}
