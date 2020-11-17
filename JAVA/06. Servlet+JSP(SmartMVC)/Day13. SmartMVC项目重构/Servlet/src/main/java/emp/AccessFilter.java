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
 * 访问控制过滤器：只有登录的用户才能通过访问
 */
public class AccessFilter implements Filter {
	@Override
	public void doFilter(
			ServletRequest request,
			ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		//转换request和response对象的类型，这样可以
		//使用更多的API方法
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		HttpSession session = req.getSession();
		User loginUser = 
			(User)session.getAttribute("loginUser");
		if(loginUser==null) {
			System.out.println("没有登录，转到登录"); 
			//没有登录，重定向到登录页面，不执行后续链节
			String login=req.getContextPath()+
					"/user/start-login.do";
			res.sendRedirect(login);
			return; //不执行后续链节
		}
		//执行后续链节，就是执行后续的Servlet
		System.out.println("登录成功，继续执行"); 
		chain.doFilter(req, res); 
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}
