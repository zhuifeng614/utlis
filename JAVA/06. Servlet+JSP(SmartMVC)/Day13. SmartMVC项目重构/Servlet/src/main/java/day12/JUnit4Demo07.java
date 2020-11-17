package day12;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Scanner;

public class JUnit4Demo07 {
	public static void main(String[] args)
		throws Exception{
		/**
		 * JUnit4 的原型: 执行某个类中标注了 @Test 注解的方法。
		 */
		Scanner in = new Scanner(System.in);
		System.out.print("输入测试案例类名:");
		String className = in.nextLine();
		Class cls = Class.forName(className);
		Method[] methods = cls.getDeclaredMethods();
		Object obj = cls.newInstance();
		for (Method method : methods) {
			//查找方法上的某个注解getAnnotation(注解类)
			//如果找到指定注解，则返回一个注解对象
			//如果找不到指定注解，则返回null
			Annotation ann=method.getAnnotation(Test.class);
			if(ann==null) continue;
			method.invoke(obj);
		}
	}
}








