package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 集合的排序
 * 集合工具类:java.util.Collections
 * 该类提供了一个静态方法sort,可以对List集合进行自然
 * 排序。
 * @author ta
 *
 */
public class SortListDemo1 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Random random = new Random();
		for(int i=0;i<10;i++) {
			list.add(random.nextInt(100));
		}
		System.out.println(list);
		
		Collections.sort(list);
		
		System.out.println(list);
		
		//乱序
		Collections.shuffle(list);
		
		System.out.println(list);
		
	}
}








