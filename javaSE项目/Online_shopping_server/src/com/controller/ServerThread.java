package com.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;



public class ServerThread implements Runnable {
	//客户端Socket对象
	private Socket client;
	//创建业务层对象
	private ShopController controller;
	public ServerThread(Socket client) {
		super();
		this.client = client;
		this.controller=new Controller();		
	}
	//构造方法
	@Override
	public void run() {
		//创建输入流
		try {
			ObjectInputStream in=new ObjectInputStream(client.getInputStream());
			//获取方法名称
			String methodName = in.readUTF();
			//获取参数列表数据类型
			Class<?>[] parameterTypes = (Class<?>[]) in.readObject();
			//获取参数数据
			Object[] arr=(Object[]) in.readObject();
			//利用反射获取方法对象
			Method method = controller.getClass().getMethod(methodName, parameterTypes);
			//利用方法对象进行方法调用
			Object result = method.invoke(controller, arr);
			//获取输出流将结果发送给客户端
			ObjectOutputStream out=new ObjectOutputStream(client.getOutputStream());
			//发送数据
			out.writeObject(result);
			//刷新缓冲区
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
