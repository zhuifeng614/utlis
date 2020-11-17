package exception;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JDK7�Ƴ�ʱ���Ƴ���һ������:�Զ��ر� AutoCloseable
 * 
 * @author ta
 *
 */
public class ExceptionDemo4 {
	public static void main(String[] args) {
		/*
		 * ע��,try����Բ�����ж�������ݶ�����ʵ����
		 * AutoCloseable�ӿڡ�
		 * ��������Ǳ������Ͽɵģ��������ڱ��뵱ǰԴ��
		 * ��ʱ�Ὣ���ﶨ����������ո�Ϊ��finally�йر�
		 */
		try(
			FileOutputStream fos
				= new FileOutputStream("fos.txt");	
		){
			fos.write(1);
		}catch(IOException e) {
			System.out.println("������!");
		}
	}
}






