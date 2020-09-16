package com.baizhi.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.ItemDao;
import com.baizhi.dao.OrderDao;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.service.ItemService;
import com.baizhi.util.MybatisUtil;

public class ItemServiceImpl implements ItemService{

	@Override
	public List<Item> selectOneItem(String oid) {
		System.out.print("ssssssssss"+oid);
		List<Item> selectOne=null;
		try{
			ItemDao dao = (ItemDao)MybatisUtil.getMapper(ItemDao.class);
			OrderDao odao = (OrderDao)MybatisUtil.getMapper(OrderDao.class);
			HttpSession session = ServletActionContext.getRequest().getSession();
			System.out.println("sdfasdddddddddddddddddddddd");
			selectOne = dao.selectOneItem(oid);
			
			System.out.println(selectOne);
			Order order=null;
			for (Item item : selectOne) {
				String order_id = item.getOrder_id();
				order = odao.selectOneOrder(order_id);
				String order_no = order.getOrder_no();
				Double total = order.getTotal();
				String status = order.getStatus();
				session.setAttribute("order_no", order_no);
				session.setAttribute("total", total);
				session.setAttribute("status", status);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return selectOne;
	}

}
