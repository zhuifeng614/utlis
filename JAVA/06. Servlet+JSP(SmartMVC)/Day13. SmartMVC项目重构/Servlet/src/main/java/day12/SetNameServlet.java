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
	 * �̲߳�����ȫ����ʾ
	 */
	protected void doGet(
		HttpServletRequest request, 
		HttpServletResponse response) 
		throws ServletException, IOException {
		//��ȡִ�е�ǰdoGet�������̣߳�����߳�
		//��Tomcat���̳߳ع������ڴ���ǰhttp����
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







