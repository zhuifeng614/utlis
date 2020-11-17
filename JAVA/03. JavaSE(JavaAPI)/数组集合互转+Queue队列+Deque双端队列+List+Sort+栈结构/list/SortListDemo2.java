package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import collection.Point;
/**
 * 排序自定义类型元素时
 * @author ta
 *
 */
public class SortListDemo2 {
	public static void main(String[] args) {
		List<Point> list = new ArrayList<>();
		list.add(new Point(3,4));
		list.add(new Point(7,9));
		list.add(new Point(2,6));
		list.add(new Point(25,67));
		list.add(new Point(1,8));
		list.add(new Point(12,34));		
		System.out.println(list);
		/*
		 * 该sort方法要求集合元素必须实现Comparable
		 * 接口，否则编译不通过。
		 */
//		Collections.sort(list);
		Collections.sort(list,new Comparator<Point>(){
			/**
			 * 该方法用来指定o1与o2的大小关系
			 * 返回值不关心具体取值，只关心取值范围
			 * 当返回值>0:o1>o2
			 * 当返回值<0:o1<o2
			 * 当返回值=0:o1与o2相等
			 */
			public int compare(Point o1, Point o2) {
				int len1 = o1.getX()*o1.getX()+o1.getY()*o1.getY();
				int len2 = o2.getX()*o2.getX()+o2.getY()*o2.getY();
				return len1-len2;
			}
		});
		System.out.println(list);
	}
}










