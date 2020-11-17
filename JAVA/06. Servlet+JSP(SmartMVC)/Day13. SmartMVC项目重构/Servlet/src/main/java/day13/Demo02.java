package day13;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import mvc.HandlerMapping;
import mvc.RequestHandler;

public class Demo02 {

	public static void main(String[] args) 
		throws Exception {
		/**
		 * 测试 HandlerMapping的初始化方法是否可用
		 */
		HandlerMapping mapping = new HandlerMapping();
		mapping.init("mvc.BizController"); 
		
		//执行 /test/add.do 对应的方法
//		String path = "/test/add.do";
//		RequestHandler handler=mapping.get(path);
//		Method method = handler.getMethod();
//		Object controller = handler.getController();
//		HttpServletRequest req=null;
//		Object val = method.invoke(controller, req);
//		System.out.println(val);
		
		//执行 /test/add.do 对应的方法
		String val = mapping.execute(
				"/test/add.do", null);
		System.out.println(val);	 
	}

}




