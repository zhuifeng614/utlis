package reflect;

import java.lang.reflect.Constructor;

/**
 * �����вι�����
 * @author ta
 *
 */
public class ReflectDemo3 {
	public static void main(String[] args) throws Exception {
	
		
		//1��ȡ�����
		Class cls = Class.forName("reflect.Person");
		//2��ȡ��Ӧ�����Ĺ��췽��
		Constructor c = cls.getConstructor(String.class);
		//3ͨ���������������ʵ����
		Object o = c.newInstance("����");
		
//		Constructor c = cls.getConstructor(
//			String.class,int.class);
//		Object o = c.newInstance("����",22);
		
		
		System.out.println(o);
	}
}









