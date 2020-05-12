package com.view;

import java.util.Collection;
import java.util.List;

import com.entity.Category;
import com.entity.Invite;
import com.entity.Order;
import com.entity.OrderItem;
import com.entity.Product;
import com.entity.Review;

public class View {
	public void mainMenu() {
		System.out.println("欢迎来到网上购物平台(尽量不要出现中文)");
		System.out.println("1.登录");
		System.out.println("2.注册");
		System.out.println("0.退出");		
	}
	public void loginMenu() {
		System.out.println("登录界面");
	}
	public void registerMenu() {
		System.out.println("注册界面");
	}
	public void userMenu() {
		System.out.println("用户界面");
		System.out.println("1.分类查看商品");
		System.out.println("2.查询商品");
		System.out.println("3.查看购物车");
		System.out.println("4.查看所有订单");
		System.out.println("0.退出登录");
	}
	public void merchantsMenu() {
		System.out.println("商家界面");
		System.out.println("1.商品操作");
		System.out.println("2.订单操作");
		System.out.println("3.统计销量");
		System.out.println("4.邀请查看");
		System.out.println("0.退出登录");
	}
	public void productMenu() {
		System.out.println("商品操作");
		System.out.println("1.商品增加");
		System.out.println("2.商品修改");
		System.out.println("3.商品查询");
		System.out.println("0.返回上一层");
	}
	public void printCategoryAll(List<Category> list) {
		System.out.println("类别界面");
		System.out.printf("%-5s","id");
		System.out.printf("%-15s","name");
		System.out.println();
		for (Category c : list) {
			System.out.printf("%-5s",c.getId());
			System.out.printf("%-15s",c.getName());
			System.out.println();
		}
	}
	public void printProductAll(List<Product> list) {
		System.out.println("商品界面");
		System.out.printf("%-5s","id");
		System.out.printf("%-20s","name");
		System.out.printf("%-15s","orignalPrice");
		System.out.printf("%-15s","promotePrice");
		System.out.printf("%-8s","stock");
		System.out.printf("%-5s","cid");
		System.out.printf("%-15s","name");
		System.out.printf("%-25s","createDate");
		System.out.println();
		for (Product p : list) {
			System.out.printf("%-5s",p.getId());
			System.out.printf("%-20s",p.getName());
			System.out.printf("%-15s",p.getOrignalPrice());
			System.out.printf("%-15s",p.getPromotePrice());
			System.out.printf("%-8s",p.getStock());
			System.out.printf("%-5s",p.getCid());
			System.out.printf("%-15s",p.getCategory().getName());
			System.out.printf("%-25s",p.getCreateDate());
			System.out.println();
		}
	}
	public void printStatistical(Collection<Product> list) {
		System.out.println("商品界面");
		System.out.printf("%-5s","id");
		System.out.printf("%-20s","name");
		System.out.printf("%-15s","orignalPrice");
		System.out.printf("%-15s","promotePrice");
		System.out.printf("%-8s","stock");
		System.out.printf("%-10s","saleCount");
		System.out.printf("%-5s","cid");
		System.out.printf("%-25s","createDate");
		System.out.println();
		for (Product p : list) {
			System.out.printf("%-5s",p.getId());
			System.out.printf("%-20s",p.getName());
			System.out.printf("%-15s",p.getOrignalPrice());
			System.out.printf("%-15s",p.getPromotePrice());
			System.out.printf("%-8s",p.getStock());
			System.out.printf("%-10s",p.getSaleCount());			
			System.out.printf("%-5s",p.getCid());
			System.out.printf("%-25s",p.getCreateDate());
			System.out.println();
		}
	}
	public void printOrderItemAll(List<OrderItem> list) {
		System.out.println("购物车界面");
		System.out.printf("%-5s","id");
		System.out.printf("%-5s","pid");
		System.out.printf("%-20s","name");
		System.out.printf("%-5s","uid");
		System.out.printf("%-8s","number");
		System.out.printf("%-10s","total");
		System.out.println();
		for (OrderItem o : list) {
			System.out.printf("%-5s",o.getId());
			System.out.printf("%-5s",o.getPid());
			System.out.printf("%-20s",o.getProduct().getName());
			System.out.printf("%-5s",o.getUid());
			System.out.printf("%-8s",o.getNumber());
			System.out.printf("%-10s",o.getProduct().getPromotePrice()*o.getNumber());
			System.out.println();
		}
	}
	
	public void printOrderAll(List<Order> list) {
		System.out.println("订单界面");
		System.out.printf(" %-5s","id");
		System.out.printf("%-5s","oid");
		System.out.printf("%-20s","address");
		System.out.printf("%-10s","receiver");
		System.out.printf("%-15s","mobile");
		System.out.printf("%-25s","createDate");
		System.out.printf("%-25s","deliveryDate");
		System.out.printf("%-25s","confirmDate");
		System.out.printf("%-5s","status");
		System.out.println();
		for (Order o : list) {
			System.out.printf(" %-5s",o.getId());
			System.out.printf("%-5s",o.getOid());
			System.out.printf("%-20s",o.getAddress());
			System.out.printf("%-10s",o.getReceiver());
			System.out.printf("%-15s",o.getMobile());
			System.out.printf("%-25s",o.getCreateDate());
			System.out.printf("%-25s",o.getDeliveryDate());
			System.out.printf("%-25s",o.getConfirmDate());
			System.out.printf("%-5s",o.getStatus());
			System.out.println();
		}
	}
	public void printReview(Review r) {
		System.out.println(r.getUser().getName());
		System.out.println(r.getContent());
		System.out.println(r.getCreateDate());
	}
	public void printInvite(List<Invite> list) {
		System.out.println("邀请码界面(1商家，6-10买家)");
		System.out.printf(" %-5s","id");
		System.out.printf("%-8s","status");
		System.out.println();
		for (Invite invite : list) {
			System.out.printf(" %-5s",invite.getCode());
			System.out.printf("%-8s",invite.getStatus());
			System.out.println();
		}
	}
}
