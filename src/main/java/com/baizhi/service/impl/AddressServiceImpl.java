package com.baizhi.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AddressDao;
import com.baizhi.dao.ItemDao;
import com.baizhi.dao.OrderDao;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.Address;
import com.baizhi.entity.Book;
import com.baizhi.entity.CartItem;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.entity.User;
import com.baizhi.service.AddressService;
import com.baizhi.util.MybatisUtil;

public class AddressServiceImpl implements AddressService {

	@Override
	public List<Address> selectAllAddress(String id) {
		// TODO Auto-generated method stub
		AddressDao dao = (AddressDao) MybatisUtil.getMapper(AddressDao.class);
		List<Address> addressList = null;
		try {
			addressList = dao.selectAllAddress(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisUtil.close();
		}

		return addressList;
	}

	@Override
	public Address selectOneAddress(String addressid) {
		// TODO Auto-generated method stub
		AddressDao dao = (AddressDao) MybatisUtil.getMapper(AddressDao.class);
		Address address = new Address();
		try {
			address = dao.selectOneAddress(addressid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisUtil.close();
		}

		return address;
	}

	public void addOrder(Address address) {
		// 获取AddressDao.BookDao.OrderDao.session
		AddressDao dao = (AddressDao) MybatisUtil.getMapper(AddressDao.class);
		OrderDao orderDao = (OrderDao)MybatisUtil.getMapper(OrderDao.class);
		ItemDao itemDao = (ItemDao)MybatisUtil.getMapper(ItemDao.class);
		UserDao userDao = (UserDao)MybatisUtil.getMapper(UserDao.class);
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		Map<Integer,CartItem> map = (Map<Integer,CartItem>)session.getAttribute("cart"); //购物车数据
		Double total =(Double)session.getAttribute("totalMoney");
		
		try {
			// 1 处理地址数据
			// 先判断改地址是新地址还是旧地址，新地址就添加，旧地址就再判断
			if (address.getId() == null || "".equals(address.getId())) {
				address.setId(UUID.randomUUID().toString());
				address.setUser_id(user.getId());
				dao.addAddress(address);

			} else {
				// 判断当前地址有没有修改，如果有 修改数据库数据，如果没有 不操作
				Address add = dao.selectOneAddress(address.getId());
				if (!add.equals(address)) {
					dao.updateOneAddress(address);
				}
			}

			// 2 处理订单数据(生成一个订单)
			Order order = new Order();
			Date date = new Date();
			order.setId(UUID.randomUUID().toString());
			order.setOrder_no(date.getTime()+"");//date.getTime() 是lang类型的     
			order.setTotal(total);
			order.setCreate_date(date);
			order.setStatus("未支付");
			order.setUser_id(user.getId());
			order.setAddress_id(address.getId());
			order.setName(address.getName());
			order.setLocal(address.getLocal());
			System.out.println(order.getId()+"   "+order.getTotal());
			session.setAttribute("order", order);
			System.out.println("生成的订单对象"+order);
			orderDao.addOrder(order);
			
			// 3 处理订单项数据（生成一个订单项）
			Set<Integer> set = map.keySet();
			for(Integer id : set){
				CartItem cart = map.get(id);
				Book book = cart.getBook();
				Item item = new Item();
				item.setId(UUID.randomUUID().toString());
				item.setBook_id(id);
				item.setOrder_id(order.getId());
				item.setCount(cart.getCount());
				item.setCreat_date(date);
				item.setName(book.getName());
				item.setCount(cart.getCount());
				item.setPrice(book.getPrice());
				item.setDprice(book.getDprice());
				
				session.setAttribute("item", item);
				itemDao.addItem(item);
				
				// 4 修改图书数据
				book.setSale(book.getSale()+cart.getCount());
				book.setStock(book.getStock()-cart.getCount());
				userDao.updateBook(book);
				
				
			}
			// 5 销毁购物车
			session.removeAttribute("cart");
			session.setAttribute("orderNo", order.getOrder_no());
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
			e.printStackTrace();
		}

	}

}
