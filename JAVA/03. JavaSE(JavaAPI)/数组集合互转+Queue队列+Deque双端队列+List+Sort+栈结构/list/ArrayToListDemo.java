package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 将数组转换为集合
 * 
 * 数组的工具类:java.util.Arrays提供了一个静态方法
 * asList,可以将一个数组转换为一个List集合
 * @author ta
 *
 */
public class ArrayToListDemo {
	public static void main(String[] args) {
		String[] array = {"one","two","three","four"};
		
		List<String> list = Arrays.asList(array);
		System.out.println(list.size());
		System.out.println(list);
		//对集合元素操作就是对数组操作
		list.set(1, "2");
		System.out.println(list);
		System.out.println(Arrays.toString(array));
		
		//由于数组定长，因此集合不允许增删元素
//		list.add("five");//会抛出不支持操作的异常
		
		//若希望增删元素，需自行创建一个集合
		List<String> list1 = new ArrayList<>(list);	
		System.out.println("list1:"+list1);
		list1.add("five");
		System.out.println("list1:"+list1);
	}
}







