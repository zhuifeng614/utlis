package demo;

import java.util.List;

public class Demo04 {

	public static void main(String[] args) {
		/**
		 * ����ģʽ���ڲ��ı�ԭ�й��������Ϊ�����չ���ܡ�
		 * 
		 *  ProxyList ��ԭ��ArrayList ����֮��
		 *  ��չ�߳�ͬ�����ܣ�ʵ�����̰߳�ȫ
		 *  
		 */
		List<String> list = new ProxyList<String>();
		
		list.add("Tom");
		list.add("Jerry");
		list.add("Andy");
		
		System.out.println(list); 
	}

}
