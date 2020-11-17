package day12;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Demo05 {

	public static void main(String[] args)
		throws Exception {
		/**
		 * ���÷���API�ҵ������ϱ�ע��ע��
		 */
		String className = "day12.TestCase";
		//��̬������
		Class cls=Class.forName(className);
		//��̬�������������ȫ������
		Method [] methods=cls.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
			//Method ��API�����Լ�ⷽ���ϱ�ע��ע��
			Annotation[] anns=method.getAnnotations();
			for (Annotation ann : anns) {
				System.out.println(ann); 
			}
		}
	}
}









