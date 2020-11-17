package cn.tedu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("hello.do")
	public String showHello() {
		System.out.println("HelloController.showHello()");
		return "index";
	}
	
}
