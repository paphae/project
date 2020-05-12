package com.util;

import java.util.Scanner;

public class UserInput {
	//����һ�����������ķ���
	public int getInt(String msg){
		System.out.println(msg);
		while(true){
			try{
				Scanner sc=new Scanner(System.in);
				return sc.nextInt();
			}catch (Exception e) {
				System.out.println("�Բ����ʽ����ȷ������ѡ��1~n");
			}
		}
	}
	//����һ�����븡�����ķ���
	public double getDouble(String msg){
		System.out.println(msg);
		while(true){
			try{
				Scanner sc=new Scanner(System.in);
				return sc.nextDouble();
			}catch (Exception e) {
				System.out.println("�Բ����ʽ����ȷ����������");
			}
		}
	}
	//����һ���������ڽ����ַ���
	public String getString(String msg){
		System.out.println(msg);
		Scanner sc=new Scanner(System.in);
		return sc.next();
	}
}
