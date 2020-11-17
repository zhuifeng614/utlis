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
		//obj变量的类型是Object，obj引用的对象是什么类型？
		//在程序中检查 obj 引用的对象的类型？
		//obj.getClass() 是java在Object类型上定义的
		//方法， 可以动态获取当前对象的类型！
		Class cls = obj.getClass();
		System.out.println(cls); 
		
		//Class 类型上提供检查类的内部结构方法
		//Field: 字段，就是类中声明的成员变量
		//Declared: 声明的 
		// getDeclaredFields 获取cls类型的上声明的
		// 全部成员变量，包含静态变量和实例变量
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field); 
		}
		// Method: 方法
		// getDeclaredMethods 返回cls类的定义的全部方法
		Method[] methods = cls.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		//cls.getDeclaredConstructors() 全部构造器
		System.out.println("------------"); 
		//
	}

}




