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
		System.out.println("��ӭ�������Ϲ���ƽ̨(������Ҫ��������)");
		System.out.println("1.��¼");
		System.out.println("2.ע��");
		System.out.println("0.�˳�");		
	}
	public void loginMenu() {
		System.out.println("��¼����");
	}
	public void registerMenu() {
		System.out.println("ע�����");
	}
	public void userMenu() {
		System.out.println("�û�����");
		System.out.println("1.����鿴��Ʒ");
		System.out.println("2.��ѯ��Ʒ");
		System.out.println("3.�鿴���ﳵ");
		System.out.println("4.�鿴���ж���");
		System.out.println("0.�˳���¼");
	}
	public void merchantsMenu() {
		System.out.println("�̼ҽ���");
		System.out.println("1.��Ʒ����");
		System.out.println("2.��������");
		System.out.println("3.ͳ������");
		System.out.println("4.����鿴");
		System.out.println("0.�˳���¼");
	}
	public void productMenu() {
		System.out.println("��Ʒ����");
		System.out.println("1.��Ʒ����");
		System.out.println("2.��Ʒ�޸�");
		System.out.println("3.��Ʒ��ѯ");
		System.out.println("0.������һ��");
	}
	public void printCategoryAll(List<Category> list) {
		System.out.println("������");
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
		System.out.println("��Ʒ����");
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
		System.out.println("��Ʒ����");
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
		System.out.println("���ﳵ����");
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
		System.out.println("��������");
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
		System.out.println("���������(1�̼ң�6-10���)");
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
