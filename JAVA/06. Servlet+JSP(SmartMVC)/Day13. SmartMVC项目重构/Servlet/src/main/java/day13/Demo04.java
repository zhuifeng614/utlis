package day13;

import mvc.ContextConfigListener;
import mvc.HandlerMapping;

public class Demo04 {

	public static void main(String[] args)
		throws Exception {
		/**
		 * 测试: 读取配置文件，初始化 HandlerMapping
		 */
		ContextConfigListener l = 
				new ContextConfigListener();
		HandlerMapping mapping=
				l.loadControlers("beans.xml");
	}

}




