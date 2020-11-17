package day12;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RealPathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ��ʾ����ȡjava web·����Ӧ��ʵ�ʴ洢λ��
	 */
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {

		String webpath = "/WEB-INF/jsp";
		
		ServletContext ctx=getServletContext();
		//�ҵ� java web ·����ʵ�ʴ洢·��λ��
		String realpath = ctx.getRealPath(webpath);
		System.out.println(realpath);
		//����һ�� jsp �ļ����е�����
		File dir = new File(realpath);
		//�������г����ļ�������
		File[] files = dir.listFiles();
		for (File file : files) {
			System.out.println(file);
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("OK"); 
	}

}





