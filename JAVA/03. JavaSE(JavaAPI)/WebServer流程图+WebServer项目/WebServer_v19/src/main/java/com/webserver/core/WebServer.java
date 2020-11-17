package com.webserver.core;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * WebServer主类
 * @author ta
 *
 */
public class WebServer {
	private ServerSocket server;
	
	private ExecutorService threadPool;
	
	public WebServer() {
		try {
			System.out.println("正在启动服务端...");
			server = new ServerSocket(8089);
			threadPool = Executors.newFixedThreadPool(100);
			System.out.println("服务端启动完毕!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		try {
			while(true) {
				System.out.println("等待客户端连接...");
				Socket socket = server.accept();
				System.out.println("一个客户端连接了!");
				ClientHandler handler 
					= new ClientHandler(socket);
				
				threadPool.execute(handler);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		WebServer server = new WebServer();
		server.start();
	}
}











