package mvc;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class HandlerMapping {
	/**
	 * map 用于映射 请求 path 到对应的请求处理器
	 * 如：将 /emp/list.do 映射到 bizColtroller.list()方法
	 */
	private Map<String, RequestHandler> map=new HashMap<>();

	/**
	 * 用于根据 path 执行对应控制器方法
	 * @param path 请求路径
	 * @param request 执行控制器时候的参数
	 * @return 控制器执行以后的返回值
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
	 * 初始化方法：解析控制器中的注解，将注解和注解
	 * 标注的方法添加到 map中
	 * @param className 控制器类名
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
				//找到注解上标注的路径
				String path=ann.value();
				//创建请求处理器对象，封装控制器对象和方法
				RequestHandler handler=
						new RequestHandler(
						controller, method);
				//请求路径和对应的“请求处理器”添加到map
				map.put(path, handler);
				System.out.println(path+":"+handler); 
			}
		}
	}
}






