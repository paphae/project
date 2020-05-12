package com.util;

import java.util.Scanner;

public class UserInput {
	//创建一个输入整数的方法
	public int getInt(String msg){
		System.out.println(msg);
		while(true){
			try{
				Scanner sc=new Scanner(System.in);
				return sc.nextInt();
			}catch (Exception e) {
				System.out.println("对不起格式不正确请输入选项1~n");
			}
		}
	}
	//创建一个输入浮点数的方法
	public double getDouble(String msg){
		System.out.println(msg);
		while(true){
			try{
				Scanner sc=new Scanner(System.in);
				return sc.nextDouble();
			}catch (Exception e) {
				System.out.println("对不起格式不正确请输入数字");
			}
		}
	}
	//创建一个方法用于接收字符串
	public String getString(String msg){
		System.out.println(msg);
		Scanner sc=new Scanner(System.in);
		return sc.next();
	}
}
