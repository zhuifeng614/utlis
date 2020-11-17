package day12;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo03 {

	public static void main(String[] args) {
		test("123");
		test(123);
		test(123.0);
	}
	
	public static void test(Object obj) {
		//obj������������Object��obj���õĶ�����ʲô���ͣ�
		//�ڳ����м�� obj ���õĶ�������ͣ�
		//obj.getClass() ��java��Object�����϶����
		//������ ���Զ�̬��ȡ��ǰ��������ͣ�
		Class cls = obj.getClass();
		System.out.println(cls); 
		
		//Class �������ṩ�������ڲ��ṹ����
		//Field: �ֶΣ��������������ĳ�Ա����
		//Declared: ������ 
		// getDeclaredFields ��ȡcls���͵���������
		// ȫ����Ա������������̬������ʵ������
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field); 
		}
		// Method: ����
		// getDeclaredMethods ����cls��Ķ����ȫ������
		Method[] methods = cls.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		//cls.getDeclaredConstructors() ȫ��������
		System.out.println("------------"); 
		//
	}

}




