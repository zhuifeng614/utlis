package mvc;

import java.lang.reflect.Method;

/**
 * Handler 处理器
 * 请求处理器，用处理用户请求
 * 封装控制器对象和控制器上的业务方法 
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
