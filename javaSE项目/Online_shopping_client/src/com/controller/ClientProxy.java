package com.controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

//����һ���ͻ��˴���
public class ClientProxy {
	//����һ���������ڻ�ȡ�������
	//��һ��������Ҫ�ӿڵ������
	//�ڶ�������ip��ַ 
	//�����������˿ں�
	public static Object getProxy(Class<?> interfaceClass,String ip,int port){
		//���ش������
		return Proxy.newProxyInstance(interfaceClass.getClassLoader(),
				new Class[]{interfaceClass},
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//�����׽��ֶ��������������
						Socket client=new Socket(ip, port);
						//��ȡ�����
						ObjectOutputStream out=new ObjectOutputStream(client.getOutputStream());
						//��������  ���õķ�������
						out.writeUTF(method.getName());
						out.flush();
						//���ͷ��������б���������
						out.writeObject(method.getParameterTypes());
						out.flush();
						//���Ͳ�������
						out.writeObject(args);
						out.flush();
						//���ط���ִ�еĽ��
						//������������ȡ�������
						ObjectInputStream in=new ObjectInputStream(client.getInputStream());
						return in.readObject();
					}
				});
	}
}
