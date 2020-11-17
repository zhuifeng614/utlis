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
	 * 演示，获取java web路径对应的实际存储位置
	 */
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {

		String webpath = "/WEB-INF/jsp";
		
		ServletContext ctx=getServletContext();
		//找到 java web 路径的实际存储路径位置
		String realpath = ctx.getRealPath(webpath);
		System.out.println(realpath);
		//遍历一下 jsp 文件夹中的内容
		File dir = new File(realpath);
		//遍历（列出）文件夹内容
		File[] files = dir.listFiles();
		for (File file : files) {
			System.out.println(file);
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("OK"); 
	}

}





