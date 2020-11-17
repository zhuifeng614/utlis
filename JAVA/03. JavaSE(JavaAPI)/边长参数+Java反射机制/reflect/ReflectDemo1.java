package reflect;

import java.lang.reflect.Method;

/**
 * java �������
 * 
 * ������һ�ֶ�̬���ƣ�ʹ���������ڳ��������ڼ��ȡ
 * һ����ĸ�����Ϣ�����÷�����ʵ�����ȡ�
 * ʹ�÷��������ߴ������ȣ����ǻ������Ǹ������
 * �ܿ��������Է���Ҫ�ʶ�ʹ�á�
 * 
 * 
 * Class��
 * ���������ÿһ��ʵ�����ڱ�ʾJVM���ص�һ���ࡣ
 * ������JVM�ڲ���ÿ�������ص�������ֻ��һ�������
 * ͨ���������Ե�֪���ʾ�����һ����Ϣ(��������
 * ��Щ���������ԣ��������ȡ�)�����ҿ��Կ���ʵ����
 * �����ʵ����
 * 
 * ��ȡһ���������������ַ�ʽ:
 * 1:ֱ�ӵ��ø���ľ�̬����class�õ������ַ�ʽ����
 *   ����ǵ�ȷ��Ҫ����ĳ����������ʱ����ʹ�á�
 *   ��:
 *   Class cls = String.class;
 *   Class cls = ArrayList.class;
 *   Class cls = int.class;
 *   
 * 2:ʹ��Class�ľ�̬����forName����
 *   Class cls = Class.forName("java.lang.String");
 *   
 * 3:ʹ���������ClassLoader    
 * 
 * @author ta
 *
 */
public class ReflectDemo1 {
	public static void main(String[] args) throws ClassNotFoundException {
		/*
		 * ��ȡString�������
		 */
		Class cls = Class.forName("java.lang.String");
//		Class cls = String.class;
		
		/*
		 * java.lang.String
		 * java.util.ArrayList
		 * java.util.HashMap
		 */
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("������Ҫ���ص�����:");
//		String className = scanner.nextLine();
//		Class cls = Class.forName(className);
		/*
		 * ��ȡClass��ʾ���������
		 */
		String name = cls.getName();
		System.out.println(name);
		
		/*
		 * ��ȡ��������з���
		 * Method���ÿ��ʵ�����ڱ�ʾһ������ķ���
		 */
		Method[] methods = cls.getMethods();
		for(Method m : methods) {
			System.out.println(m.getName());
		}

	}
}








