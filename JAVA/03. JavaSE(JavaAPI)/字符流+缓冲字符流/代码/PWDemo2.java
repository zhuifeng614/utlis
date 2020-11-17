package io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * ����������ʹ��PW����ı����ݵ�д������
 * @author ta
 *
 */
public class PWDemo2 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�������ļ���:");
		String fileName = scanner.nextLine();
		
		FileOutputStream fos
			= new FileOutputStream(fileName);		
		OutputStreamWriter osw
			= new OutputStreamWriter(fos,"GBK");		
		BufferedWriter bw
			= new BufferedWriter(osw);
		/*
		 * ���������д���PrintWriterʱ�������ٴ���
		 * һ����������ֵΪbooleanֵ������ֵΪtrue
		 * ��ǰPW�������Զ���ˢ�¹��ܡ�
		 * ��ʱÿ�����ǵ���println������д��ָ��
		 * ���ݾͻ��Զ�flush.
		 */
		PrintWriter pw
			= new PrintWriter(bw,true);	
		
		System.out.println("�뿪ʼ��������:");
		while(true) {
			String line = scanner.nextLine();
			if("exit".equals(line)) {
				break;
			}
			//ע�⣬����print�����ǲ���flush��!
			pw.println(line);
			
		}
		System.out.println("�ټ�!");
		pw.close();
	}
}





