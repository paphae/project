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
	// ����һ���������
	private ShopController controller;
	private User u;
	// ��������
	public static final String IP = "182.92.85.87";
//	public static final String IP = "127.0.0.1";
	public static final int PORT = 9999;
	// ��������
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
			int select = ui.getInt("��ѡ��");
			switch (select) {
			case 1:
				v.loginMenu();
				int status = login();
				if (status == 0) {
					System.out.println("�û��������벻��ȷ");
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
			int select = ui.getInt("��ѡ��");
			switch (select) {
			case 1:
				productOperate();
				break;
			case 2:
				orderOperate();
				break;
			case 3:
				// ͳ��
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
		if("y".equalsIgnoreCase(ui.getString("�Ƿ����������[y/n]"))) {
			String msg = controller.inviteAdd(new Invite(ui.getInt("����Ȩ��")));
			System.out.println(msg);
		}
	}

	private void statistical() {
		List<Order> list = controller.orderSelectSales();
		if(list==null) {System.out.println("��δ������Ʒ");return ;}
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
		List<Order> list = controller.orderSelectStatus("������");
		if(list==null||list.isEmpty()) {System.out.println("û��Ҫ����Ķ���");return ;}
		v.printOrderAll(list);
		if("y".equalsIgnoreCase(ui.getString("�Ƿ�����[y/n]"))) {
			Order order = controller.orderSelectById(ui.getInt("ѡ��Ҫ����Ķ���"));
			if(order==null)return ;
			OrderItem orderItem = controller.orderItemSelectById(order.getOid());
			Product pro = controller.productSelectById(orderItem.getPid());
			if(pro.getStock()-orderItem.getNumber()>=0) {
				pro.setStock(pro.getStock()-orderItem.getNumber());
				String msg = controller.productUpdate(pro);
				System.out.println(msg);
				order.setDeliveryDate(DButil.d2t(new Date()));
				order.setStatus("�ѷ���");
				String msg2 = controller.orderUpdate(order);
				System.out.println(msg2);
			}
			else
				System.out.println("��治��");
		}
	}

	private void productOperate() {
		v.productMenu();
		int select  = ui.getInt("��ѡ��");
		switch (select) {
		case 1:
			String msg = controller.productAdd(new Product(ui.getString("name"), ui.getDouble("orignalPrice"), 
					ui.getDouble("promotePrice"), ui.getInt("stock"), ui.getInt("cid"), DButil.d2t(new Date())));
			System.out.println(msg);
			break;
		case 2:
			Product pro = controller.productSelectById(ui.getInt("Ҫ�޸ĵ���Ʒid"));
			if(pro==null) {System.out.println("û�и���Ʒ");return ;}
			List<Product> pros = new ArrayList<Product>();
			pros.add(pro);
			v.printProductAll(pros);
			pro.setName(ui.getString("����"));
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
			int select = ui.getInt("��ѡ��");
			switch (select) {
			case 1:
				// �����ѯ����ӵ����ﳵ
				categoryQuery();
				break;
			case 2:
				// ��ȷ��ѯ����ӵ����ﳵ
				nameQuery();
				break;
			case 3:
				// �鿴���ﳵ
				cartQuery();
				break;
			case 4:
				// �鿴����
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
		if(all==null) {System.out.println("û�ж���");return ;}
		v.printOrderAll(all);
		if("y".equalsIgnoreCase(ui.getString("�Ƿ�ȷ���ջ�[y/n]"))) {
			Order order = controller.orderSelectById(ui.getInt("ȷ���ջ��Ķ�����"));
			if(order==null) {System.out.println("û�иö���");return ;}
			order.setConfirmDate(DButil.d2t(new Date()));
			order.setStatus("������");
			String msg = controller.orderUpdate(order);
			System.out.println(msg);
		}
		if("y".equalsIgnoreCase(ui.getString("�Ƿ����۶���[y/n]"))) {
			Order order = controller.orderSelectById(ui.getInt("ѡ�����۵Ķ�����"));
			if(order==null) {System.out.println("û�иö���");return ;}
			controller.reviewAdd(new Review(ui.getString("��������"),
					u.getId(),order.getId(),DButil.d2t(new Date())));
			order.setStatus("���");
			String msg = controller.orderUpdate(order);
			System.out.println(msg);
		}if("y".equalsIgnoreCase(ui.getString("�Ƿ�鿴��������[y/n]"))) {
			Review review = controller.reviewSelectByCode(ui.getInt("ѡ�񶩵���"));
			if(review==null) {System.out.println("δ����");return ;}
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
		if(all.isEmpty()) {System.out.println("δ�������ﳵ");return ;}
		for (OrderItem o : all) {
			o.setProduct(controller.productSelectById(o.getPid()));
		}
		v.printOrderItemAll(all);
		if("y".equalsIgnoreCase(ui.getString("�Ƿ��޸Ĺ��ﳵ��Ʒ[y/n]"))) {
			OrderItem item = controller.orderItemSelectById(ui.getInt("ѡ���ﳵ"));
			if(item==null) {System.out.println("û�иù��ﳵ");return ;}
			item.setNumber(ui.getInt("����"));
			String msg = controller.orderItemUpdate(item);
			System.out.println(msg);
		}
		if("y".equalsIgnoreCase(ui.getString("�Ƿ��ύ����[y/n]"))) {
			String msg = controller.orderAdd(new Order(ui.getInt("���ﳵid"),
					ui.getString("��ַ"), ui.getString("�ջ�����Ϣ"), ui.getString("�ջ����ֻ���"),
					DButil.d2t(new Date()), null, null, "������"));
			System.out.println(msg);
		}
	}

	private void nameQuery() {
		Product pro = controller.productSelectByName(ui.getString("������Ʒ���ƣ�"));
		if(pro==null) {System.out.println("û�и���Ʒ");return ;}
		Category category = controller.categorySelectById(pro.getCid());
		pro.setCategory(category);
		List<Product> list = new ArrayList<Product>();
		list.add(pro);
		v.printProductAll(list);
		if("y".equalsIgnoreCase(ui.getString("�Ƿ������Ʒ�����ﳵ[y/n]"))) {
			String msg = controller.orderItemAdd(new OrderItem(pro.getId(),
					u.getId(),ui.getInt("����������")));
			System.out.println(msg);
		}
	}

	private void categoryQuery() {
		List<Category> all = controller.categorySelectAll();
		v.printCategoryAll(all);
		int select  = ui.getInt("��ѡ��");
		List<Product> list = controller.productSelectByCid(select);
		if(list==null) {System.out.println("���������");return ;}
		Category category = controller.categorySelectById(select);
		if(category==null) {System.out.println("���������");return ;}
		for (Product p : list) {
			p.setCategory(category);
		}
		v.printProductAll(list);
		if("y".equalsIgnoreCase(ui.getString("�Ƿ������Ʒ�����ﳵ[y/n]"))) {
			String msg = controller.orderItemAdd(new OrderItem(ui.getInt("������Ʒid"),
					u.getId(),ui.getInt("����������")));
			System.out.println(msg);
		}
	}

	private boolean register() {
		String name = ui.getString("����");
		String account = ui.getString("�û���");
		String password = ui.getString("����");
		int code = ui.getInt("������");
		Invite inv = controller.inviteSelectByCode(code);
		int status = 10;
		if (inv != null)
			status = inv.getStatus();
		String msg = controller.Useradd(new User(name, account, password, status));
		System.out.println(msg);
		if(msg.equals("�û����Ѵ���"))return false;
		u = controller.userSelectByAccountAndPassword(account, password);
		return u!=null;
	}

	private int login() {
		String account = ui.getString("�û���");
		String password = ui.getString("����");
		u = controller.userSelectByAccountAndPassword(account, password);
		if (u != null)
			return u.getStatus();
		return 0;
	}
}
