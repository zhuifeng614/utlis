package emp;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;

/**
 * ���ʿ��ƹ�������ֻ�е�¼���û�����ͨ������
 */
public class AccessFilter implements Filter {
	@Override
	public void doFilter(
			ServletRequest request,
			ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		//ת��request��response��������ͣ���������
		//ʹ�ø����API����
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		HttpSession session = req.getSession();
		User loginUser = 
			(User)session.getAttribute("loginUser");
		if(loginUser==null) {
			System.out.println("û�е�¼��ת����¼"); 
			//û�е�¼���ض��򵽵�¼ҳ�棬��ִ�к�������
			String login=req.getContextPath()+
					"/user/start-login.do";
			res.sendRedirect(login);
			return; //��ִ�к�������
		}
		//ִ�к������ڣ�����ִ�к�����Servlet
		System.out.println("��¼�ɹ�������ִ��"); 
		chain.doFilter(req, res); 
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}
