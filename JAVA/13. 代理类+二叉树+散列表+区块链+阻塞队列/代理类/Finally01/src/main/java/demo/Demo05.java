package demo;

import java.io.Serializable;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo05 {

	public static void main(String[] args) {
		/**
		 * 使用动态代理API创建接口的实例
		 */
		String[] arr1={"Tom","Andy","Jerry"};
		String[] arr=new String[]{"Tom","Andy","Jerry"};
		String[] arr3;
		//arr3 = {"A","B"}; 
		//{}创建数组，仅限于声明变量直接初始时候使用
		//其他情况下，请使用完整的数组声明语法
		arr3 = new String[] {"A","B"}; 
		
		//接口列表
		Class[] infs = new Class[]{List.class,Serializable.class};
		
		List<String> list=(List<String>)
				Proxy.newProxyInstance(
				Demo05.class.getClassLoader(), //类加载器
				new Class[] {List.class}, //实现接口类型列表
				new ProxyHandler<String>());//调用处理器对象
		
		list.add("Andy");
		list.add("Jerry");
		list.add("Tom");
		list.add("Lee");
		
		System.out.println(list); 
		
		//Java 线程安全解List决方案之一
		List<String> lst=new ArrayList<String>();
		lst=Collections.synchronizedList(lst);
		
		
	}

}







