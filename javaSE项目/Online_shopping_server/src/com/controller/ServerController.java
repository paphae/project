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
	//����serverSocker������
	private ServerSocket server;
	//���峣����ʾ�˿ں�
	public static final int PORT=9999;
	//���޸ĳ��̳߳�
	private ExecutorService es;
	public ServerController() {
		super();
		try {
			System.out.println("������������....");
			Thread.sleep(1000);
			this.server = new ServerSocket(PORT);
			System.out.println("�������ѿ���!");
			//ʵ�����̳߳�
			this.es=Executors.newCachedThreadPool();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("����������ʧ��");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//����controller��������
	public void start(){
		while(true){
			System.out.println("�ȴ��ͻ���������......");
			//�ȴ��ͻ��˶�������
			try {
				Socket client= server.accept();
				System.out.println("�ͻ���["+client.getInetAddress().getHostName()+"]�Ѿ�����");
				//���ͻ��˶�����뵽�̳߳���
				this.es.execute(new ServerThread(client));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("�ͻ��˽���ʧ��");
			}
		}
	
	}
	

}
