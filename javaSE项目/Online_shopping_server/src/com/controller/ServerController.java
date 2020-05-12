package com.controller;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ServerController {
	//创建serverSocker服务器
	private ServerSocket server;
	//定义常量表示端口号
	public static final int PORT=9999;
	//将修改成线程池
	private ExecutorService es;
	public ServerController() {
		super();
		try {
			System.out.println("服务器开启中....");
			Thread.sleep(1000);
			this.server = new ServerSocket(PORT);
			System.out.println("服务器已开启!");
			//实例化线程池
			this.es=Executors.newCachedThreadPool();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("服务器创建失败");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//创建controller启动方法
	public void start(){
		while(true){
			System.out.println("等待客户端链接中......");
			//等待客户端对象链接
			try {
				Socket client= server.accept();
				System.out.println("客户端["+client.getInetAddress().getHostName()+"]已经链接");
				//将客户端对象放入到线程池中
				this.es.execute(new ServerThread(client));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("客户端接收失败");
			}
		}
	
	}
	

}
