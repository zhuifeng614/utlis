package day12;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo06 {

	public static void main(String[] args)
		throws Exception{
		/**
		 * ���÷���API��ִ̬�з���
		 * ���ݶ�̬����������ͷ������� ���÷���API
		 * �����࣬�ҵ��������������󣬵��÷�����
		 */
		//��̬���������ͷ�����
		Scanner in = new Scanner(System.in);
		System.out.print("����������");
		String className = in.nextLine();
		System.out.print("���뷽����:");
		String methodName=in.nextLine();
		//������
		Class cls = Class.forName(className);
		//����API��cls���ҵ�Ҫ���õķ���
		//getDeclaredMethod �����ϸ���methodNameѰ��
		//һ�� Method ��������Ҳ����׳��쳣
		Method method=
		  cls.getDeclaredMethod(methodName);
		//��̬����һ��cls�Ķ���
		Object obj = cls.newInstance();
		//ִ�з���, invoke ����ִ�з��������Ǳ����ṩ
		//���������Ķ���, ��������ϲ������������׳��쳣
		Object val = method.invoke(obj);
		System.out.println(val); 
	}

}







