package reflect;

import java.util.Scanner;

/**
 * ͨ��Classʵ����
 * @author ta
 *
 */
public class ReflectDemo2 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		Person p = new Person();
		System.out.println(p);
		
		/*
		 * ���÷���ʵ��������
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("������Ҫʵ�����������");
		String className = scanner.nextLine();
		Class cls = Class.forName(className);
		Object o = cls.newInstance();
		System.out.println(o);
		//1��ȡҪʵ��������������
//		Class cls = Class.forName("reflect.Person");
		
		//2ͨ��Classʵ����
//		Person p1 = (Person)cls.newInstance();
		
//		System.out.println(p1);
	}
}






