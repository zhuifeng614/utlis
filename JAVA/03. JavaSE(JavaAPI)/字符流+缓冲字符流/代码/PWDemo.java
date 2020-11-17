package io;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 缓冲字符流
 * 缓冲字符流读写字符数据效率高，并且有一个特点就是
 * 可以按行读写文本数据。
 * 
 * java.io.BufferedWriter 缓冲字符输出流
 * java.io.BufferedReader 缓冲字符输入流
 * 
 * java.io.PrintWriter 具有自动行刷新的缓冲字符
 * 输出流，内部总是连接BufferedWriter作为加速操作。
 * 
 * @author ta
 *
 */
public class PWDemo {
	public static void main(String[] args) throws IOException {
		PrintWriter pw
			= new PrintWriter("pw.txt","UTF-8");
		
		pw.println("我可以接受你的所有，所有小脾气.");
		pw.println("我可以带你去吃很多，很多好东西.");
		pw.println("我可以偶尔给你带来，带来小甜蜜.");
		System.out.println("写出完毕!");
		pw.close();
		
	}
}








