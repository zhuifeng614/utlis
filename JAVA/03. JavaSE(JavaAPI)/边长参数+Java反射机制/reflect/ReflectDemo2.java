package reflect;

import java.util.Scanner;

/**
 * 通过Class实例化
 * @author ta
 *
 */
public class ReflectDemo2 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		Person p = new Person();
		System.out.println(p);
		
		/*
		 * 利用反射实例化对象
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要实例化类的名字");
		String className = scanner.nextLine();
		Class cls = Class.forName(className);
		Object o = cls.newInstance();
		System.out.println(o);
		//1获取要实例化的类的类对象
//		Class cls = Class.forName("reflect.Person");
		
		//2通过Class实例化
//		Person p1 = (Person)cls.newInstance();
		
//		System.out.println(p1);
	}
}






