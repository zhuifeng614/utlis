package collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 集合的遍历
 * Iterator iterator()
 * 该方法可以获取一个用于遍历当前集合的迭代器实现类
 * 通过Iterator就可以遍历集合元素了。
 * 
 * java.util.Iterator接口
 * 该接口规定了所有迭代器实现类遍历集合的通用操作方法
 * 而遍历集合遵循的步骤为:问，取，删
 * 其中删除元素不是必要操作。
 * 
 * 不同的集合都提供了一个Iterator的实现类，我们无需
 * 记住这些实现类的名字，以Iterator接口接收并调用
 * 方法遍历即可。
 * 
 * @author ta
 *
 */
public class CollectionDemo6 {
	public static void main(String[] args) {
		Collection c = new HashSet();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		c.add("#");
		c.add("five");
		System.out.println(c);
		
		Iterator it = c.iterator();
		/*
		 * boolean hasNext()
		 * 通过迭代器判断集合是否含有元素可以遍历
		 */
		while(it.hasNext()) {
			/*
			 * E next()
			 * 获取集合下一个元素
			 */
			String str = (String)it.next();
			System.out.println(str);
			if("#".equals(str)) {
				/*
				 * 迭代器遍历集合有一个要求，遍历
				 * 的过程中不能通过集合的方法增删
				 * 元素，否则会抛出异常
				 */
//				c.remove(str);
				/*
				 * 迭代器的remove方法不需要传参，
				 * 删除的就是本次遍历时next()得到的
				 * 元素
				 */
				it.remove();
			}
		}
		System.out.println(c);
	}
}














