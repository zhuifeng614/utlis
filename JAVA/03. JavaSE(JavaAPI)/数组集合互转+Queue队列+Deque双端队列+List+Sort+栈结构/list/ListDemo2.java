package list;

import java.util.ArrayList;
import java.util.List;

/**
 * List�����ṩ��һ�����ص�add��remove����
 * @author ta
 *
 */
public class ListDemo2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);
		
		/*
		 * void add(int index,E e)
		 * ������Ԫ�ز��뵽ָ��λ��
		 */
		//[one,two,2,three,four]
		list.add(2,"2");
		System.out.println(list);
		
		/*
		 * E remove(int index)
		 * ɾ��������ֵָ���±괦��Ӧ��Ԫ��
		 */
		//[one,2,three,four]
		String old = list.remove(1);
		System.out.println(list);
		System.out.println(old);
	}
}







