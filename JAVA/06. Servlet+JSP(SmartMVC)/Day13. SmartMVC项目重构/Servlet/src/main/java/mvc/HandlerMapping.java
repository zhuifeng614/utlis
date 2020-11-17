package mvc;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class HandlerMapping {
	/**
	 * map ����ӳ�� ���� path ����Ӧ����������
	 * �磺�� /emp/list.do ӳ�䵽 bizColtroller.list()����
	 */
	private Map<String, RequestHandler> map=new HashMap<>();

	/**
	 * ���ڸ��� path ִ�ж�Ӧ����������
	 * @param path ����·��
	 * @param request ִ�п�����ʱ��Ĳ���
	 * @return ������ִ���Ժ�ķ���ֵ
	 */
	public String execute(String path, 
			HttpServletRequest request)
		throws Exception {
		RequestHandler handler = get(path);
		Method method = handler.getMethod();
		Object controller = handler.getController();
		Object val = method.invoke(
				controller, request);
		String value = (String)val;
		return value;
	}
	
	public RequestHandler get(String path) {
		return map.get(path);
	}
	
	/**
	 * ��ʼ�������������������е�ע�⣬��ע���ע��
	 * ��ע�ķ�����ӵ� map��
	 * @param className ����������
	 */
	public void init(String className) 
		throws Exception{
		Class cls = Class.forName(className);
		Method[] methods = cls.getDeclaredMethods();
		Object controller = cls.newInstance();
		for(Method method:methods) {
			RequestMapping ann = method
				.getAnnotation(RequestMapping.class);
			if(ann!=null) {
				//�ҵ�ע���ϱ�ע��·��
				String path=ann.value();
				//���������������󣬷�װ����������ͷ���
				RequestHandler handler=
						new RequestHandler(
						controller, method);
				//����·���Ͷ�Ӧ�ġ�������������ӵ�map
				map.put(path, handler);
				System.out.println(path+":"+handler); 
			}
		}
	}
}






