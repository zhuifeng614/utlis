package io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 在流连接中使用PW完成文本数据的写出操作
 * @author ta
 *
 */
public class PWDemo2 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入文件名:");
		String fileName = scanner.nextLine();
		
		FileOutputStream fos
			= new FileOutputStream(fileName);		
		OutputStreamWriter osw
			= new OutputStreamWriter(fos,"GBK");		
		BufferedWriter bw
			= new BufferedWriter(osw);
		/*
		 * 在流连接中创建PrintWriter时，可以再传入
		 * 一个参数，该值为boolean值，若该值为true
		 * 则当前PW具有了自动行刷新功能。
		 * 此时每当我们调用println方法后，写出指定
		 * 内容就会自动flush.
		 */
		PrintWriter pw
			= new PrintWriter(bw,true);	
		
		System.out.println("请开始输入内容:");
		while(true) {
			String line = scanner.nextLine();
			if("exit".equals(line)) {
				break;
			}
			//注意，调用print方法是不会flush的!
			pw.println(line);
			
		}
		System.out.println("再见!");
		pw.close();
	}
}





