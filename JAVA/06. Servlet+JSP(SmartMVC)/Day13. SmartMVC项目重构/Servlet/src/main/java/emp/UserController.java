package emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.User;
import mvc.RequestMapping;

public class UserController {
	
	@RequestMapping("/user/login.do")
	public String login(HttpServletRequest request) {
		//��ȡ������
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String save = request.getParameter("save");
		
		// �������ݲ㣬����û���Ϣ
		UserDao dao = new UserDao();
		User user = dao.findUserByName(name.trim());
		
		//���û��������� request��
		request.setAttribute("name",name);
		
		//String contextPath = request.getContextPath();
		//request.setAttribute("root", contextPath); 
		
		//���û���ҵ��û���Ϣ����ʾ�û����Ǵ����
		if(user==null) {
			//ת�ص���¼ҳ����ʾ������Ϣ
			request.setAttribute("message", 
					"�û��������������"); 
			return "login";
		}
		//�ҵ��û���Ϣ�����ж������Ƿ���ȷ
		//�ĸ�����������Ϊnull�ŵ�ǰ��
		if( user.getName().equals(name) && 
			user.getPassword().equals(password)) {
			//���������ȣ� ����Ե�¼
			//����¼��������� session 
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			
			//ת������Ϣҳ����ʾ��¼�ɹ���Ϣ
			request.setAttribute("message", "��¼�ɹ�");
			return "message";
		}
		//ִ�е����λ�ã����벻һ�µ�����
		request.setAttribute("message", 
				"�û��������������");
 
		return "login";
	}
	@RequestMapping("/user/start-login.do")
	public String startLogin(HttpServletRequest request) {
		return "login";
	}
}







