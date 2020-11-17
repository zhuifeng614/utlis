package cn.tedu.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("LoginInterceptor.preHandle()");
		// ��ȡHttpSession����
		HttpSession session = request.getSession();
		// �ж�Session����û�е�¼������
		if (session.getAttribute("username") == null) {
			// û�е�¼���ݣ���δ��¼�����ض��򵽵�¼ҳ
			// http://localhost:8080/XX/index.do
			// http://localhost:8080/XX/user/password.do
			String projectName = request.getServletContext().getContextPath();
			response.sendRedirect(projectName + "/user/login.do");
			// ����false��ʾ���أ����������ִ��
			return false;
		}
		// ����true��ʾ���У��������ִ��
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("LoginInterceptor.postHandle()");
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("LoginInterceptor.afterCompletion()");
	}


}
