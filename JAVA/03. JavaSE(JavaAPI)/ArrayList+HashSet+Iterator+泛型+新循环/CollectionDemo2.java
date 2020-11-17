package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * boolean contains(E e)
 * 判断集合是否包含给定元素
 * 
 * @author ta
 *
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Point(1,2));
		c.add(new Point(3,4));
		c.add(new Point(5,6));
		c.add(new Point(7,8));
		System.out.println(c);
		
		Point p = new Point(1,2);
		/*
		 * 集合判断包含的标准是，只要集合中的元素与
		 * 给定的这个元素有equals比较为true的情况
		 * 就认为包含。
		 */
		boolean contains = c.contains(p);
		System.out.println("包含:"+contains);
	}
}







