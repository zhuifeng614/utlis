package day13;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import mvc.HandlerMapping;
import mvc.RequestHandler;

public class Demo02 {

	public static void main(String[] args) 
		throws Exception {
		/**
		 * ���� HandlerMapping�ĳ�ʼ�������Ƿ����
		 */
		HandlerMapping mapping = new HandlerMapping();
		mapping.init("mvc.BizController"); 
		
		//ִ�� /test/add.do ��Ӧ�ķ���
//		String path = "/test/add.do";
//		RequestHandler handler=mapping.get(path);
//		Method method = handler.getMethod();
//		Object controller = handler.getController();
//		HttpServletRequest req=null;
//		Object val = method.invoke(controller, req);
//		System.out.println(val);
		
		//ִ�� /test/add.do ��Ӧ�ķ���
		String val = mapping.execute(
				"/test/add.do", null);
		System.out.println(val);	 
	}

}




