package day13;

import java.lang.reflect.Method;

import mvc.RequestMapping;

public class Demo01 {

	public static void main(String[] args) 
		throws Exception{
		/*
		 * 解析 BizController类的@RequestMapping注解
		 */
		String className="mvc.BizController";
		//动态加载类
		Class cls = Class.forName(className);
		//动态找到类的上全部方法
		Method[] methods=cls.getDeclaredMethods();
		//遍历全部方法，查找标注的 @RequestMapping 注解
		for(Method method:methods) {
			//利用RequestMapping.class类型找到的对象
			//是 RequestMapping 类型的对象，包含value方法
			RequestMapping ann=method.getAnnotation(
					RequestMapping.class);
			if(ann!=null) {
				//调用注解对象上的 value方法就能取到标注的值
				String val = ann.value();
				System.out.println(val); 
				System.out.println(method);
			}
		}
		
	}

}




