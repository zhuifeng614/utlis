package mvc;

import javax.servlet.http.HttpServletRequest;

/**
 * �������࣬ ���ڷ�װҵ���ܣ� 
 */
public class BizController {
	
	/**
	 * ��һ��ҵ���ܣ�Hello World! 
	 * @return Ŀ��ҳ������
	 */
	public String execute(HttpServletRequest request) {
		System.out.println("Hello World!");
		request.setAttribute("msg", "Hello"); 
		return "hello"; 
	}
	/**
	 * ������ /emp/list.do ��ʾԱ���б�
	 * ��Web���������ڼ䣬 ��/emp/list.do����ӳ�䵽
	 * list() �����ϣ�Ҳ��������/emp/list.doʱ��
	 * ִ��list()����
	 */
	@RequestMapping("/test/list.do")
	public String list(HttpServletRequest request) {
		return "list";
	}
	/**
	 * ������ /emp/add.do ��ʾ���Ա������
	 */
	@RequestMapping("/test/add.do")
	public String add(HttpServletRequest request) {
		return "add";
	}
	
	@RequestMapping("/test/hello.do")
	public String hello(HttpServletRequest request) {
		request.setAttribute("msg", "HI"); 
		return "hello";
	}
	// ...
	
	@RequestMapping("/test/test.do")
	public String test(HttpServletRequest request) {
		//�����ض�����
		String path=request.getContextPath()+
				"/emp/list.do";
		return "redirect:"+path;
	}
	
}












