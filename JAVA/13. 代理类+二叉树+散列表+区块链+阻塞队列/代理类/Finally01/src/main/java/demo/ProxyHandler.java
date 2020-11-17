package demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 调用处理器 
 */
public class ProxyHandler<E> 
	implements InvocationHandler {
	private List<E> target;//被代理的目标对象
	public ProxyHandler() {
		target = new ArrayList<E>();
	}
	public ProxyHandler(List<E> target) {
		this.target = target;
	}

	//返回值是目标方法执行以后的返回值
	public Object invoke(
			Object proxy, //动态生成的代理对象
			Method method,//正在被调用的方法
			Object[] args)//调用方法时候传递的实际参数
			throws Throwable {
		System.out.println("正在调用："+method);
		synchronized (proxy) {
			//在target对象上执行method对应的方法
			return method.invoke(target, args);
			//假设     add()         list    e
			//则执行了 ： list.add(e) 
		}
	}
}


