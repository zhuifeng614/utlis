package day12;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Scanner;

public class JUnit4Demo07 {
	public static void main(String[] args)
		throws Exception{
		/**
		 * JUnit4 ��ԭ��: ִ��ĳ�����б�ע�� @Test ע��ķ�����
		 */
		Scanner in = new Scanner(System.in);
		System.out.print("������԰�������:");
		String className = in.nextLine();
		Class cls = Class.forName(className);
		Method[] methods = cls.getDeclaredMethods();
		Object obj = cls.newInstance();
		for (Method method : methods) {
			//���ҷ����ϵ�ĳ��ע��getAnnotation(ע����)
			//����ҵ�ָ��ע�⣬�򷵻�һ��ע�����
			//����Ҳ���ָ��ע�⣬�򷵻�null
			Annotation ann=method.getAnnotation(Test.class);
			if(ann==null) continue;
			method.invoke(obj);
		}
	}
}








