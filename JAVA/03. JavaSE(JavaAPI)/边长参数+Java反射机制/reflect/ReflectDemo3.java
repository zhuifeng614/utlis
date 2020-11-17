package reflect;

import java.lang.reflect.Constructor;

/**
 * 调用有参构造器
 * @author ta
 *
 */
public class ReflectDemo3 {
	public static void main(String[] args) throws Exception {
	
		
		//1获取类对象
		Class cls = Class.forName("reflect.Person");
		//2获取对应参数的构造方法
		Constructor c = cls.getConstructor(String.class);
		//3通过构造器对象进行实例化
		Object o = c.newInstance("张三");
		
//		Constructor c = cls.getConstructor(
//			String.class,int.class);
//		Object o = c.newInstance("张三",22);
		
		
		System.out.println(o);
	}
}









