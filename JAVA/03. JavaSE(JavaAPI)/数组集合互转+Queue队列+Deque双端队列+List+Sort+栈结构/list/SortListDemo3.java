package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * 对数字进行倒序
 * @author ta
 *
 */
public class SortListDemo3 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Random random = new Random();
		for(int i=0;i<10;i++) {
			list.add(random.nextInt(100));
		}
		System.out.println(list);
		
		Collections.sort(list,new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
		System.out.println(list);
	}
}




