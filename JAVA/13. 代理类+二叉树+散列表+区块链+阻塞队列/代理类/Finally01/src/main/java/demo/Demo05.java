package demo;

import java.io.Serializable;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo05 {

	public static void main(String[] args) {
		/**
		 * ʹ�ö�̬����API�����ӿڵ�ʵ��
		 */
		String[] arr1={"Tom","Andy","Jerry"};
		String[] arr=new String[]{"Tom","Andy","Jerry"};
		String[] arr3;
		//arr3 = {"A","B"}; 
		//{}�������飬��������������ֱ�ӳ�ʼʱ��ʹ��
		//��������£���ʹ�����������������﷨
		arr3 = new String[] {"A","B"}; 
		
		//�ӿ��б�
		Class[] infs = new Class[]{List.class,Serializable.class};
		
		List<String> list=(List<String>)
				Proxy.newProxyInstance(
				Demo05.class.getClassLoader(), //�������
				new Class[] {List.class}, //ʵ�ֽӿ������б�
				new ProxyHandler<String>());//���ô���������
		
		list.add("Andy");
		list.add("Jerry");
		list.add("Tom");
		list.add("Lee");
		
		System.out.println(list); 
		
		//Java �̰߳�ȫ��List������֮һ
		List<String> lst=new ArrayList<String>();
		lst=Collections.synchronizedList(lst);
		
		
	}

}







