package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * JDK5 推出时推出的另一个特性:泛型
 * 泛型也称为参数化类型，可以在使用一个类的时候传入
 * 某个类型用来指定这个类中属性的类型，方法参数或返回
 * 值的类型。这可以提高代码的灵活度。
 * 
 * 泛型应用最多的地方就是集合，用来指定集合中的元素类型
 * @author ta
 *
 */
public class CollectionDemo7 {
	public static void main(String[] args) {
		/*
		 * 泛型的实际类型只能指定引用类型，若希望指定
		 * 基本类型时需要指定其对应的包装类类型
		 * Collection<Integer> c; 可以
		 * Collection<int> c;     编译不通过
		 */
		Collection<String> c
				= new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
//		c.add(1); //编译不通过
		System.out.println(c);
		/*
		 * 指定过泛型的集合，在使用新循环遍历时可以
		 * 直接用指定的类型接收集合元素
		 */
		for(String str : c) {
			System.out.println(str);
		}
		/*
		 * 迭代器也支持泛型，指定时应当与其遍历的集合
		 * 泛型类型一致。
		 */
		Iterator<String> it = c.iterator();
		while(it.hasNext()) {
			//获取元素时无需再造型
			String str = it.next();
			System.out.println(str);
		}
		
		
	}
}







