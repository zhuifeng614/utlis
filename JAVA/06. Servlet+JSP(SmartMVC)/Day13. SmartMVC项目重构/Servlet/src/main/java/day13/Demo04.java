package day13;

import mvc.ContextConfigListener;
import mvc.HandlerMapping;

public class Demo04 {

	public static void main(String[] args)
		throws Exception {
		/**
		 * ����: ��ȡ�����ļ�����ʼ�� HandlerMapping
		 */
		ContextConfigListener l = 
				new ContextConfigListener();
		HandlerMapping mapping=
				l.loadControlers("beans.xml");
	}

}




