package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 排序字符串
 * @author ta
 *
 */
public class SortListDemo4 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("苍老师");
		list.add("传奇");
		list.add("小泽老师");	
		System.out.println(list);
		/*
		 * 字符串也实现了Comparable接口，定义的比较
		 * 规则是按照字符的unicode代码从小到大，但是
		 * 排序中文就没什么意义了。
		 */
		Collections.sort(list);
		System.out.println(list);
		
		//按照字符多少排序
		Collections.sort(list,new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}	
		});
		System.out.println(list);
	}
}





