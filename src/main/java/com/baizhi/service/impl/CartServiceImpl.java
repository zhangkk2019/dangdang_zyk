package com.baizhi.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.CartItem;
import com.baizhi.service.AdminService;
import com.baizhi.service.CartService;

public class CartServiceImpl implements CartService {
	// 添加购物车
	public void addCart(int id) {
		try {
			// 获取相应Dao.session
			AdminService service = new AdminServiceImpl();
			Book book = service.selectOneBook(id);
			
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			// 1.是否是第一次购买商品，如果是 创建新的购物车，如果不是 使用旧的购物车
			Map<Integer, CartItem> map = (Map<Integer, CartItem>) session
					.getAttribute("cart");
			
			if (map == null) {
				Double totalMoney = 0.0;
				Double saveMoney = 0.0;
				// 说明是第一次购买商品
				map = new HashMap<Integer, CartItem>();
				CartItem item = new CartItem();
				item.setBook(book);
				item.setCount(1);
				map.put(id, item);
				totalMoney = book.getDprice();
				saveMoney = book.getPrice() - book.getDprice();
				session.setAttribute("totalMoney", totalMoney);
				session.setAttribute("saveMoney", saveMoney);
			} else {
				// 说明不是第一次购买商品
				// 2.判断是否是第一次购买该类商品。如果是 添加新的购物项，如果不是 在之前的基础上进行累加
				if (map.containsKey(id)) {
					// 说明之前买过该类商品
					Double totalMoney = (Double)session.getAttribute("totalMoney");
					Double saveMoney = (Double)session.getAttribute("saveMoney");
					
					CartItem item = map.get(id);
					item.setCount(item.getCount() + 1);
					map.put(id, item);
					totalMoney = totalMoney + book.getDprice();
					saveMoney = saveMoney + book.getPrice()-book.getDprice();
					session.setAttribute("totalMoney", totalMoney);
					session.setAttribute("saveMoney", saveMoney);
				} else {
					// 之前没有买过此类商品
					Double totalMoney = (Double)session.getAttribute("totalMoney");
					Double saveMoney = (Double)session.getAttribute("saveMoney");
					
					CartItem item = new CartItem();
					item.setBook(book);
					item.setCount(1);
					map.put(id, item);
					totalMoney =totalMoney + book.getDprice();
					saveMoney = saveMoney + book.getPrice() - book.getDprice();
					session.setAttribute("totalMoney", totalMoney);
					session.setAttribute("saveMoney", saveMoney);
				}
			}
			session.setAttribute("cart", map);
			
			System.out.println(session.getAttribute("cart"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	// 变更数量
	public void updateCount(int count, int id) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session
				.getAttribute("cart");
		CartItem item = cart.get(id);
		Book book = item.getBook();
		double saveMoney = (Double) session.getAttribute("saveMoney");
		double totalMoney = (Double) session.getAttribute("totalMoney");
		if (count >= 0) {
			if (count > item.getCount()) {
				saveMoney += (count - item.getCount())
						* (book.getPrice() - book.getDprice());
				totalMoney += (count - item.getCount()) * book.getDprice();
			} else {
				saveMoney -= (item.getCount() - count)
						* (book.getPrice() - book.getDprice());
				totalMoney -= (item.getCount() - count) * book.getDprice();
			}
			item.setCount(count);
			cart.put(id, item);
			session.setAttribute("cart", cart);
			session.setAttribute("saveMoney", saveMoney);
			session.setAttribute("totalMoney", totalMoney);
		}
	}
	
	//删除购物车项
	public void deleteCart(int id){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Map<Integer,CartItem> cart = (Map<Integer,CartItem>)session.getAttribute("cart");
			CartItem item = (CartItem)cart.get(id);
			Book book = item.getBook();
			Double saveMoney = (Double)session.getAttribute("saveMoney");
			Double totalMoney = (Double)session.getAttribute("totalMoney");
			saveMoney = saveMoney-(book.getPrice()-book.getDprice())*item.getCount();
			totalMoney = totalMoney-book.getDprice()*item.getCount();
			cart.remove(id);
			if(cart.size()==0){
				session.removeAttribute("cart");
				session.removeAttribute("saveMoney");
				session.removeAttribute("totalMoney");
			}else{
				session.setAttribute("cart", cart);
				session.setAttribute("saveMoney", saveMoney);
				session.setAttribute("totalMoney", totalMoney);
			}
	}
}
