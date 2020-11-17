package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 调用方法
 * @author ta
 *
 */
public class ReflectDemo4 {
	public static void main(String[] args) throws Exception{
		Person p = new Person();
		p.sayHello();
		
		//1加载类对象
		Class cls = Class.forName("reflect.Person");
		Object o = cls.newInstance();
		
		//2获取对应方法
//		Method method = cls.getMethod("sayHello");
		Method method = cls.getMethod("say", String.class);
		
		//3执行该方法
//		method.invoke(o);
		method.invoke(o, "张三");
	}
}





