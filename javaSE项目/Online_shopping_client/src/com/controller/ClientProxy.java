package com.controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

//创建一个客户端代理
public class ClientProxy {
	//创建一个方法用于获取代理对象
	//第一个参数需要接口的类对象
	//第二个参数ip地址 
	//第三个参数端口号
	public static Object getProxy(Class<?> interfaceClass,String ip,int port){
		//返回代理对象
		return Proxy.newProxyInstance(interfaceClass.getClassLoader(),
				new Class[]{interfaceClass},
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//创建套接字对象进行网络链接
						Socket client=new Socket(ip, port);
						//获取输出流
						ObjectOutputStream out=new ObjectOutputStream(client.getOutputStream());
						//发送数据  调用的方法名称
						out.writeUTF(method.getName());
						out.flush();
						//发送方法参数列表数据类型
						out.writeObject(method.getParameterTypes());
						out.flush();
						//发送参数数据
						out.writeObject(args);
						out.flush();
						//返回方法执行的结果
						//创建输入流读取方法结果
						ObjectInputStream in=new ObjectInputStream(client.getInputStream());
						return in.readObject();
					}
				});
	}
}
