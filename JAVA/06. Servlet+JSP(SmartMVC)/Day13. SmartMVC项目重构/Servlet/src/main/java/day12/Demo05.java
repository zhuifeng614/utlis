package day12;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Demo05 {

	public static void main(String[] args)
		throws Exception {
		/**
		 * 利用反射API找到方法上标注的注解
		 */
		String className = "day12.TestCase";
		//动态加载类
		Class cls=Class.forName(className);
		//动态获得类上声明的全部方法
		Method [] methods=cls.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
			//Method 的API，可以检测方法上标注的注解
			Annotation[] anns=method.getAnnotations();
			for (Annotation ann : anns) {
				System.out.println(ann); 
			}
		}
	}
}









