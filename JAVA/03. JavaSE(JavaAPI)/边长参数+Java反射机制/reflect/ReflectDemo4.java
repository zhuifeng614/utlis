package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ���÷���
 * @author ta
 *
 */
public class ReflectDemo4 {
	public static void main(String[] args) throws Exception{
		Person p = new Person();
		p.sayHello();
		
		//1���������
		Class cls = Class.forName("reflect.Person");
		Object o = cls.newInstance();
		
		//2��ȡ��Ӧ����
//		Method method = cls.getMethod("sayHello");
		Method method = cls.getMethod("say", String.class);
		
		//3ִ�и÷���
//		method.invoke(o);
		method.invoke(o, "����");
	}
}





