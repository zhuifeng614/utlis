package day12;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo06 {

	public static void main(String[] args)
		throws Exception{
		/**
		 * 利用反射API动态执行方法
		 * 根据动态输入的类名和方法名， 利用反射API
		 * 加载类，找到方法，创建对象，调用方法。
		 */
		//动态输入类名和方法名
		Scanner in = new Scanner(System.in);
		System.out.print("输入类名：");
		String className = in.nextLine();
		System.out.print("输入方法名:");
		String methodName=in.nextLine();
		//加载类
		Class cls = Class.forName(className);
		//利用API在cls上找到要调用的方法
		//getDeclaredMethod 在类上根据methodName寻找
		//一个 Method 对象，如果找不到抛出异常
		Method method=
		  cls.getDeclaredMethod(methodName);
		//动态创建一个cls的对象
		Object obj = cls.newInstance();
		//执行方法, invoke 就是执行方法，但是必须提供
		//包含方法的对象, 如果对象上不包含方法则抛出异常
		Object val = method.invoke(obj);
		System.out.println(val); 
	}

}







