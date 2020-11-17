package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 使用新循环遍历集合
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
		 * 新循环遍历集合就是迭代器遍历
		 */
		for(Object o : c) {
			String str = (String)o;
			System.out.println(str);
		}
		
		
	}
}





