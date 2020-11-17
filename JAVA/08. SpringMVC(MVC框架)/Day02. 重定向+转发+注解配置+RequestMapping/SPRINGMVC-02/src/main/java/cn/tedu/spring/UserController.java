package cn.tedu.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
@RequestMapping(value="user")
public class UserController {

	@RequestMapping(path= {"reg.do", "register.do"}, method= {RequestMethod.POST, RequestMethod.GET}) 
	public String showRegister() {
		return "reg";
	}
	
	@RequestMapping("login.do")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("handle_reg.do")
	public String handleReg(User user) {
		System.out.println("UserController.handleReg()");
		System.out.println("\t" + user);
		
		// ע��ɹ����ض��򵽵�¼ҳ
		// ��ǰλ�ã�handle_reg.do
		// Ŀ��λ�ã�login.do
		return "redirect:login.do";
	}
	
	@RequestMapping("handle_login.do") 
	public String handleLogin(
			@RequestParam(name="uname", required=false, defaultValue="admin") String username, 
			String password,
			ModelMap modelMap) {
		// ��־
		System.out.println("UserController.handleLogin()");
		System.out.println("\tusername=" + username);
		System.out.println("\tpassword=" + password);
		
		// �ж��û����Ƿ���ȷ
		if ("root".equals(username)) {
			// �ǣ��ж������Ƿ���ȷ
			if ("1234".equals(password)) {
				// �ǣ���¼�ɹ����ض�����ҳ
				return "redirect:index.do";
			} else {
				// ���������
				modelMap.addAttribute("errorMessage", "ModelMap���������");
				return "error";
			}
		} else {
			// ���û�������
			modelMap.addAttribute("errorMessage", "ModelMap���û�������");
			return "error";
		}
	}
	
}




