package com.baizhi.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.OrderDao;
import com.baizhi.entity.Order;
import com.baizhi.service.OrderService;
import com.baizhi.util.MybatisUtil;

public class OrderServiceImpl implements OrderService {

	//查询所有订单
	public List<Order> selectAllOrder() {
		// TODO Auto-generated method stub
		OrderDao dao = (OrderDao)MybatisUtil.getMapper(OrderDao.class);
		List<Order> orderList = null;
		try{
			orderList = dao.selectAllOrder();
		}catch(Exception e){
			e.printStackTrace();
		}
		return orderList;
	}
	
	//查一个
	@Override
	public Order selectOneOrder(String id) {
		// TODO Auto-generated method stub
		OrderDao dao = (OrderDao)MybatisUtil.getMapper(OrderDao.class);
		HttpSession session = ServletActionContext.getRequest().getSession();
		Order order = null;
		try{
			order = dao.selectOneOrder(id);
			session.setAttribute("aid", order.getOrder_no());//订单id
			session.setAttribute("atotal", order.getTotal());//总金额
			session.setAttribute("astatus", order.getStatus());
		}catch(Exception e){
			e.printStackTrace();
		}
		return order;
	}

}
