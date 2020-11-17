package emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.User;
import mvc.RequestMapping;

public class UserController {
	
	@RequestMapping("/user/login.do")
	public String login(HttpServletRequest request) {
		//读取表单参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String save = request.getParameter("save");
		
		// 访问数据层，检查用户信息
		UserDao dao = new UserDao();
		User user = dao.findUserByName(name.trim());
		
		//将用户名保存在 request中
		request.setAttribute("name",name);
		
		//String contextPath = request.getContextPath();
		//request.setAttribute("root", contextPath); 
		
		//如果没有找到用户信息，表示用户名是错误的
		if(user==null) {
			//转回到登录页面显示错误消息
			request.setAttribute("message", 
					"用户名或者密码错误"); 
			return "login";
		}
		//找到用户信息，则判断密码是否正确
		//哪个变量不可能为null放到前面
		if( user.getName().equals(name) && 
			user.getPassword().equals(password)) {
			//如果密码相等， 则可以登录
			//将登录结果保存在 session 
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			
			//转发到消息页面显示登录成功消息
			request.setAttribute("message", "登录成功");
			return "message";
		}
		//执行到这个位置？密码不一致的情形
		request.setAttribute("message", 
				"用户名或者密码错误");
 
		return "login";
	}
	@RequestMapping("/user/start-login.do")
	public String startLogin(HttpServletRequest request) {
		return "login";
	}
}







