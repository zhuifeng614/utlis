package day12;

import java.util.Scanner;

public class Demo04 {

	public static void main(String[] args)
		throws Exception {
		/**
		 * ��̬�����࣬��̬��������
		 * �����ڼ�ż����࣬��������
		 */
		Scanner in = new Scanner(System.in);
		System.out.print("����������");
		String className = in.nextLine();
		//��������className��̬������
		//����������󣬻������û���ҵ��쳣
		Class cls = Class.forName(className);
		System.out.println(cls);
		//��̬���� cls ��Ӧ�Ķ���cls��������޲���������
		//���û���޲��������������׳� �޴˷����쳣
		Object obj = cls.newInstance();
		System.out.println(obj); 
	}

}







