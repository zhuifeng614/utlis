package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ʹ����ѭ����������
 * @author ta
 *
 */
public class NewForDemo2 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		System.out.println(c);
		/*
		 * ��ѭ���������Ͼ��ǵ���������
		 */
		for(Object o : c) {
			String str = (String)o;
			System.out.println(str);
		}
		
		
	}
}





