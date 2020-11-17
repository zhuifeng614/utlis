package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * java集合框架
 * 集合与数组一样，都是用来保存一组数据的，但是集合提
 * 供了操作元素的相关方法，使用更方便，并且集合有多种
 * 不同的数据结构实现。
 * 
 * java.util.Collection 接口
 * java中所有的集合都是该接口的实现类，它定义了所有集合
 * 都应当具备的功能(例如存取元素等等)
 * 
 * Collection下面常用子接口:
 * java.util.List:可重复集合，并且有序
 * java.util.Set:不可重复集合
 * 这指的重复是元素是否重复，而重复的判断依据是依靠元素
 * 自身equals比较的结果。Set集合不允许存放equals比较为
 * true的元素两次。
 * 
 * @author ta
 *
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		/*
		 * boolean add(E e)
		 * 向当前集合中添加给定元素，成功添加则
		 * 返回true,否则返回false
		 */
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		c.add("five");
		System.out.println(c);
		/*
		 * int size()
		 * 返回当前集合的元素个数
		 */
		int size = c.size();
		System.out.println("size:"+size);
		/*
		 * boolean isEmpty()
		 * 判断当前集合是否为空集(size为0时是空集)
		 */
		boolean isEmpty = c.isEmpty();
		System.out.println("是否为空集:"+isEmpty);
		
		//清空集合
		c.clear();
		System.out.println("清空集合");
		
		System.out.println(c);
		System.out.println("size:"+c.size());
		System.out.println("是否为空集:"+c.isEmpty());
	}
}









