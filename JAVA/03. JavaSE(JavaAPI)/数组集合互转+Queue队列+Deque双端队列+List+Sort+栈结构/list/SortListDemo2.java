package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import collection.Point;
/**
 * �����Զ�������Ԫ��ʱ
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
		 * ��sort����Ҫ�󼯺�Ԫ�ر���ʵ��Comparable
		 * �ӿڣ�������벻ͨ����
		 */
//		Collections.sort(list);
		Collections.sort(list,new Comparator<Point>(){
			/**
			 * �÷�������ָ��o1��o2�Ĵ�С��ϵ
			 * ����ֵ�����ľ���ȡֵ��ֻ����ȡֵ��Χ
			 * ������ֵ>0:o1>o2
			 * ������ֵ<0:o1<o2
			 * ������ֵ=0:o1��o2���
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










