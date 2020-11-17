package mvc;

import java.lang.reflect.Method;

/**
 * Handler ������
 * �����������ô����û�����
 * ��װ����������Ϳ������ϵ�ҵ�񷽷� 
 */
public class RequestHandler {
	private Object controller;
	private Method method;

	public RequestHandler() {
	}

	public RequestHandler(
			Object controller, Method method) {
		super();
		this.controller = controller;
		this.method = method;
	}

	public Object getController() {
		return controller;
	}

	public Method getMethod() {
		return method;
	}

	@Override
	public String toString() {
		return "RequestHandler [controller=" + controller + ", method=" + method + "]";
	}
	
}
