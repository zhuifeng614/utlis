package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 删除集合元素
 * @author ta
 */
public class CollectionDemo3 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Point(1,2));
		c.add(new Point(3,4));
		c.add(new Point(5,6));
		c.add(new Point(7,8));
		System.out.println(c);
		
		Point p = new Point(1,2);
		/*
		 * remove方法也是依靠元素equals比较进行删除
		 * 的，list集合中若存在重复元素，则只删除一个
		 */
		c.remove(p);
		System.out.println(c);
	}
}




