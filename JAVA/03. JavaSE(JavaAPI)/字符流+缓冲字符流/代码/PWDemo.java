package io;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * �����ַ���
 * �����ַ�����д�ַ�����Ч�ʸߣ�������һ���ص����
 * ���԰��ж�д�ı����ݡ�
 * 
 * java.io.BufferedWriter �����ַ������
 * java.io.BufferedReader �����ַ�������
 * 
 * java.io.PrintWriter �����Զ���ˢ�µĻ����ַ�
 * ��������ڲ���������BufferedWriter��Ϊ���ٲ�����
 * 
 * @author ta
 *
 */
public class PWDemo {
	public static void main(String[] args) throws IOException {
		PrintWriter pw
			= new PrintWriter("pw.txt","UTF-8");
		
		pw.println("�ҿ��Խ���������У�����СƢ��.");
		pw.println("�ҿ��Դ���ȥ�Ժܶ࣬�ܶ�ö���.");
		pw.println("�ҿ���ż���������������С����.");
		System.out.println("д�����!");
		pw.close();
		
	}
}








