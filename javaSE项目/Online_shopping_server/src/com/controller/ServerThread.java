package com.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;



public class ServerThread implements Runnable {
	//�ͻ���Socket����
	private Socket client;
	//����ҵ������
	private ShopController controller;
	public ServerThread(Socket client) {
		super();
		this.client = client;
		this.controller=new Controller();		
	}
	//���췽��
	@Override
	public void run() {
		//����������
		try {
			ObjectInputStream in=new ObjectInputStream(client.getInputStream());
			//��ȡ��������
			String methodName = in.readUTF();
			//��ȡ�����б���������
			Class<?>[] parameterTypes = (Class<?>[]) in.readObject();
			//��ȡ��������
			Object[] arr=(Object[]) in.readObject();
			//���÷����ȡ��������
			Method method = controller.getClass().getMethod(methodName, parameterTypes);
			//���÷���������з�������
			Object result = method.invoke(controller, arr);
			//��ȡ�������������͸��ͻ���
			ObjectOutputStream out=new ObjectOutputStream(client.getOutputStream());
			//��������
			out.writeObject(result);
			//ˢ�»�����
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
