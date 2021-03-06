package mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 单一前端控制器
 * 负责接收请求，处理与HTTP协议有关逻辑
 * 同时处理 get 和 post请求
 * 为了增加广泛的实用性， 可以处理任何的*.do 请求
 * 将 请求URL设置为 *.do
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		try {
			//创建 HandlerMapping 对象 
			//找到对应的业务方法，执行业务方法
			//HandlerMapping mapping = new HandlerMapping();
			//mapping.init("mvc.BizController"); 
			
			//从ServletContext获取已经创建并初始化完成的
			//HandlerMapping 对象，这样可以避免每次都初始化
			//可以提高软件的性能
			HandlerMapping mapping=(HandlerMapping)
				getServletContext().getAttribute("handlerMapping");
			
			//获取用户发起的请求
			String pth = request.getServletPath();
			System.out.println(pth); 
			
			//处理编码问题
			request.setCharacterEncoding("UTF-8");
			
			//执行 URL 路径对应的业务方法
			String target=mapping.execute(pth, request);
			//target代表需要显示是目标网页，
			//约定target是以 redirect:为前缀
			//则进行重定向，如果控制器返回的字符串
			//以 redirect: 为开头，则重定向到 
			//redirect: 以后的URL地址
			if(target.startsWith("redirect:")) {
				String path = target.substring(9);
				response.sendRedirect(path); 
			}else {
				String path = "/WEB-INF/jsp/"+target+".jsp";
				request.getRequestDispatcher(path)
					.forward(request, response); 
			}
		}catch(Exception e) {
			e.printStackTrace();
			//抛出一个 ServletException，这个异常是
			//作用是，将异常e抛给Web容器，Web容器会
			//显示 500 错误页面到浏览器
			throw new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
