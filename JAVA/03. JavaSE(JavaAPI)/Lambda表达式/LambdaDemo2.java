package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 方法中含有参数
 * @author ta
 *
 */
public class LambdaDemo2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("苍老师");
		list.add("传奇");
		list.add("小泽老师");
		System.out.println(list);
		

		Collections.sort(list,new Comparator<String>(){
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
		});
		System.out.println(list);
		/*
		 * 参数无需指定类型，编译器会根据程序上下文
		 * 分析出参数类型，若不能确定时需要指定(否则编译不通过)
		 */
//		Collections.sort(list,(o1,o2)->{
//			return o2.length()-o1.length();
//		});
		
		/*
		 * 如果可以忽略{}，那么方法中的return关键字
		 * 也要忽略
		 */
		Collections.sort(list,
			(o1,o2)->o2.length()-o1.length()
		);
		System.out.println(list);
		
	}
}








