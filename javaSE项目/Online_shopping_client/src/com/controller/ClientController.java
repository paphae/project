package com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entity.Category;
import com.entity.Invite;
import com.entity.Order;
import com.entity.OrderItem;
import com.entity.Product;
import com.entity.Review;
import com.entity.User;
import com.util.DButil;
import com.util.UserInput;
import com.view.View;

public class ClientController {
	// 创建一个代理对象
	private ShopController controller;
	private User u;
	// 创建常量
	public static final String IP = "182.92.85.87";
//	public static final String IP = "127.0.0.1";
	public static final int PORT = 9999;
	// 创建对象
	private UserInput ui;
	private View v;

	public ClientController() {
		this.controller = (ShopController) ClientProxy.getProxy(ShopController.class, IP, PORT);
		this.v = new View();
		this.ui = new UserInput();
	}

	public void start() {
		while (true) {
			v.mainMenu();
			int select = ui.getInt("请选择：");
			switch (select) {
			case 1:
				v.loginMenu();
				int status = login();
				if (status == 0) {
					System.out.println("用户名或密码不正确");
				} else if (status == 1) {
					merchantsStart();
				} else {
					userStart();
				}
				break;
			case 2:
				v.registerMenu();
				if (register()) {
					userStart();
				}
				break;
			case 0:
				System.exit(0);
				break;
			default:
				break;
			}
		}
	}

	private void merchantsStart() {
		while (true) {
			v.merchantsMenu();
			int select = ui.getInt("请选择：");
			switch (select) {
			case 1:
				productOperate();
				break;
			case 2:
				orderOperate();
				break;
			case 3:
				// 统计
				statistical();
				break;
			case 4:
				inviteOpero();
				break;
			case 0:
				return;
			default:
				break;
			}
		}
	}

	private void inviteOpero() {
		List<Invite> list = controller.inviteSelectAll();
		v.printInvite(list);
		if("y".equalsIgnoreCase(ui.getString("是否添加邀请码[y/n]"))) {
			String msg = controller.inviteAdd(new Invite(ui.getInt("输入权限")));
			System.out.println(msg);
		}
	}

	private void statistical() {
		List<Order> list = controller.orderSelectSales();
		if(list==null) {System.out.println("还未卖出商品");return ;}
		Map<Integer,Product> products = new HashMap<>();
		for (Order order : list) {
			OrderItem orderItem = controller.orderItemSelectById(order.getOid());
			Product p = controller.productSelectById(orderItem.getPid());
			if(!products.containsKey(orderItem.getPid())) {
				p.setSaleCount(orderItem.getNumber());
				products.put(orderItem.getPid(), p);
			}else {
				p.setSaleCount(products.get(orderItem.getPid()).getSaleCount()+orderItem.getNumber());
				products.replace(orderItem.getPid(), p);
			}
		}
		v.printStatistical(products.values());
	}

	private void orderOperate() {
		List<Order> list = controller.orderSelectStatus("待发货");
		if(list==null||list.isEmpty()) {System.out.println("没有要处理的订单");return ;}
		v.printOrderAll(list);
		if("y".equalsIgnoreCase(ui.getString("是否处理订单[y/n]"))) {
			Order order = controller.orderSelectById(ui.getInt("选择要处理的订单"));
			if(order==null)return ;
			OrderItem orderItem = controller.orderItemSelectById(order.getOid());
			Product pro = controller.productSelectById(orderItem.getPid());
			if(pro.getStock()-orderItem.getNumber()>=0) {
				pro.setStock(pro.getStock()-orderItem.getNumber());
				String msg = controller.productUpdate(pro);
				System.out.println(msg);
				order.setDeliveryDate(DButil.d2t(new Date()));
				order.setStatus("已发货");
				String msg2 = controller.orderUpdate(order);
				System.out.println(msg2);
			}
			else
				System.out.println("库存不足");
		}
	}

	private void productOperate() {
		v.productMenu();
		int select  = ui.getInt("请选择：");
		switch (select) {
		case 1:
			String msg = controller.productAdd(new Product(ui.getString("name"), ui.getDouble("orignalPrice"), 
					ui.getDouble("promotePrice"), ui.getInt("stock"), ui.getInt("cid"), DButil.d2t(new Date())));
			System.out.println(msg);
			break;
		case 2:
			Product pro = controller.productSelectById(ui.getInt("要修改的商品id"));
			if(pro==null) {System.out.println("没有该商品");return ;}
			List<Product> pros = new ArrayList<Product>();
			pros.add(pro);
			v.printProductAll(pros);
			pro.setName(ui.getString("名称"));
			pro.setOrignalPrice(ui.getDouble("orignalPrice"));
			pro.setPromotePrice(ui.getDouble("promotePrice"));
			pro.setStock(ui.getInt("stock"));
			List<Category> list = controller.categorySelectAll();
			v.printCategoryAll(list);
			pro.setCid(ui.getInt("cid"));
			String msg2 = controller.productUpdate(pro);
			System.out.println(msg2);
			break;
		case 3:
			List<Product> all = controller.productSelectAll();
			for (Product p : all) {
				p.setCategory(controller.categorySelectById(p.getCid()));
			}
			v.printProductAll(all);
			break;
		case 0:
			break;
		default:
			break;
		}
	}

	private void userStart() {
		while (true) {
			v.userMenu();
			int select = ui.getInt("请选择：");
			switch (select) {
			case 1:
				// 分类查询，添加到购物车
				categoryQuery();
				break;
			case 2:
				// 精确查询，添加到购物车
				nameQuery();
				break;
			case 3:
				// 查看购物车
				cartQuery();
				break;
			case 4:
				// 查看订单
				orderQuery();
				break;
			case 0:
				return;
			default:
				break;
			}
		}
	}

	private void orderQuery() {
		List<Order> all = controller.orderSelectAll();
		if(all==null) {System.out.println("没有订单");return ;}
		v.printOrderAll(all);
		if("y".equalsIgnoreCase(ui.getString("是否确认收货[y/n]"))) {
			Order order = controller.orderSelectById(ui.getInt("确认收货的订单号"));
			if(order==null) {System.out.println("没有该订单");return ;}
			order.setConfirmDate(DButil.d2t(new Date()));
			order.setStatus("待评价");
			String msg = controller.orderUpdate(order);
			System.out.println(msg);
		}
		if("y".equalsIgnoreCase(ui.getString("是否评价订单[y/n]"))) {
			Order order = controller.orderSelectById(ui.getInt("选择评价的订单号"));
			if(order==null) {System.out.println("没有该订单");return ;}
			controller.reviewAdd(new Review(ui.getString("评价内容"),
					u.getId(),order.getId(),DButil.d2t(new Date())));
			order.setStatus("完成");
			String msg = controller.orderUpdate(order);
			System.out.println(msg);
		}if("y".equalsIgnoreCase(ui.getString("是否查看订单评价[y/n]"))) {
			Review review = controller.reviewSelectByCode(ui.getInt("选择订单号"));
			if(review==null) {System.out.println("未评价");return ;}
			review.setUser(controller.userSelectById(review.getUid()));
			v.printReview(review);
		}
	}

	private void cartQuery() {
		List<OrderItem> items = controller.orderItemSelectAll();
		List<OrderItem> all = new ArrayList<OrderItem>();
		for (OrderItem orderItem : items) {
			if(orderItem.getUid().equals(u.getId()))
				all.add(orderItem);
		}
		List<Order> list = controller.orderSelectSales();
		for (Order order : list) {
			for (OrderItem o : all) {
				if(order.getOid().equals(o.getId())) {
					all.remove(o);
					break;
				}
			}
		}
		if(all.isEmpty()) {System.out.println("未创建购物车");return ;}
		for (OrderItem o : all) {
			o.setProduct(controller.productSelectById(o.getPid()));
		}
		v.printOrderItemAll(all);
		if("y".equalsIgnoreCase(ui.getString("是否修改购物车商品[y/n]"))) {
			OrderItem item = controller.orderItemSelectById(ui.getInt("选择购物车"));
			if(item==null) {System.out.println("没有该购物车");return ;}
			item.setNumber(ui.getInt("数量"));
			String msg = controller.orderItemUpdate(item);
			System.out.println(msg);
		}
		if("y".equalsIgnoreCase(ui.getString("是否提交订单[y/n]"))) {
			String msg = controller.orderAdd(new Order(ui.getInt("购物车id"),
					ui.getString("地址"), ui.getString("收货人信息"), ui.getString("收货人手机号"),
					DButil.d2t(new Date()), null, null, "待发货"));
			System.out.println(msg);
		}
	}

	private void nameQuery() {
		Product pro = controller.productSelectByName(ui.getString("输入商品名称："));
		if(pro==null) {System.out.println("没有该商品");return ;}
		Category category = controller.categorySelectById(pro.getCid());
		pro.setCategory(category);
		List<Product> list = new ArrayList<Product>();
		list.add(pro);
		v.printProductAll(list);
		if("y".equalsIgnoreCase(ui.getString("是否添加商品到购物车[y/n]"))) {
			String msg = controller.orderItemAdd(new OrderItem(pro.getId(),
					u.getId(),ui.getInt("请输入数量")));
			System.out.println(msg);
		}
	}

	private void categoryQuery() {
		List<Category> all = controller.categorySelectAll();
		v.printCategoryAll(all);
		int select  = ui.getInt("请选择：");
		List<Product> list = controller.productSelectByCid(select);
		if(list==null) {System.out.println("错误的类型");return ;}
		Category category = controller.categorySelectById(select);
		if(category==null) {System.out.println("错误的类型");return ;}
		for (Product p : list) {
			p.setCategory(category);
		}
		v.printProductAll(list);
		if("y".equalsIgnoreCase(ui.getString("是否添加商品到购物车[y/n]"))) {
			String msg = controller.orderItemAdd(new OrderItem(ui.getInt("输入商品id"),
					u.getId(),ui.getInt("请输入数量")));
			System.out.println(msg);
		}
	}

	private boolean register() {
		String name = ui.getString("姓名");
		String account = ui.getString("用户名");
		String password = ui.getString("密码");
		int code = ui.getInt("邀请码");
		Invite inv = controller.inviteSelectByCode(code);
		int status = 10;
		if (inv != null)
			status = inv.getStatus();
		String msg = controller.Useradd(new User(name, account, password, status));
		System.out.println(msg);
		if(msg.equals("用户名已存在"))return false;
		u = controller.userSelectByAccountAndPassword(account, password);
		return u!=null;
	}

	private int login() {
		String account = ui.getString("用户名");
		String password = ui.getString("密码");
		u = controller.userSelectByAccountAndPassword(account, password);
		if (u != null)
			return u.getStatus();
		return 0;
	}
}
