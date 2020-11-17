package mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��һǰ�˿�����
 * ����������󣬴�����HTTPЭ���й��߼�
 * ͬʱ���� get �� post����
 * Ϊ�����ӹ㷺��ʵ���ԣ� ���Դ����κε�*.do ����
 * �� ����URL����Ϊ *.do
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		try {
			//���� HandlerMapping ���� 
			//�ҵ���Ӧ��ҵ�񷽷���ִ��ҵ�񷽷�
			//HandlerMapping mapping = new HandlerMapping();
			//mapping.init("mvc.BizController"); 
			
			//��ServletContext��ȡ�Ѿ���������ʼ����ɵ�
			//HandlerMapping �����������Ա���ÿ�ζ���ʼ��
			//����������������
			HandlerMapping mapping=(HandlerMapping)
				getServletContext().getAttribute("handlerMapping");
			
			//��ȡ�û����������
			String pth = request.getServletPath();
			System.out.println(pth); 
			
			//�����������
			request.setCharacterEncoding("UTF-8");
			
			//ִ�� URL ·����Ӧ��ҵ�񷽷�
			String target=mapping.execute(pth, request);
			//target������Ҫ��ʾ��Ŀ����ҳ��
			//Լ��target���� redirect:Ϊǰ׺
			//������ض���������������ص��ַ���
			//�� redirect: Ϊ��ͷ�����ض��� 
			//redirect: �Ժ��URL��ַ
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
			//�׳�һ�� ServletException������쳣��
			//�����ǣ����쳣e�׸�Web������Web������
			//��ʾ 500 ����ҳ�浽�����
			throw new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
