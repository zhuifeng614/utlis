package demo;

import java.util.List;

public class Demo04 {

	public static void main(String[] args) {
		/**
		 * 代理模式：在不改变原有功能情况下为组件扩展功能。
		 * 
		 *  ProxyList 在原有ArrayList 基础之上
		 *  扩展线程同步功能，实现了线程安全
		 *  
		 */
		List<String> list = new ProxyList<String>();
		
		list.add("Tom");
		list.add("Jerry");
		list.add("Andy");
		
		System.out.println(list); 
	}

}
