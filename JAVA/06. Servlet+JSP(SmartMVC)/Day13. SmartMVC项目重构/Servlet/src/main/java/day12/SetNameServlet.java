package day12;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 */
public class SetNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String name;
	/**
	 * 线程并发安全性演示
	 */
	protected void doGet(
		HttpServletRequest request, 
		HttpServletResponse response) 
		throws ServletException, IOException {
		//获取执行当前doGet方法的线程，这个线程
		//由Tomcat的线程池管理，用于处理当前http请求
		Thread t = Thread.currentThread();
		System.out.println(t); 
		
		synchronized (this) {
			String n = request.getParameter("n");
			name = n;
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().println("name:"+name); 
		}
	}

}







