package mvc;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制器类， 用于封装业务功能， 
 */
public class BizController {
	
	/**
	 * 第一个业务功能，Hello World! 
	 * @return 目标页面名称
	 */
	public String execute(HttpServletRequest request) {
		System.out.println("Hello World!");
		request.setAttribute("msg", "Hello"); 
		return "hello"; 
	}
	/**
	 * 负责处理 /emp/list.do 显示员工列表
	 * 在Web程序运行期间， 将/emp/list.do请求映射到
	 * list() 方法上，也就是请求/emp/list.do时候，
	 * 执行list()方法
	 */
	@RequestMapping("/test/list.do")
	public String list(HttpServletRequest request) {
		return "list";
	}
	/**
	 * 负责处理 /emp/add.do 显示添加员工界面
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
		//测试重定向功能
		String path=request.getContextPath()+
				"/emp/list.do";
		return "redirect:"+path;
	}
	
}












