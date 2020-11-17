package list;

import java.util.ArrayList;
import java.util.List;

/**
 * java.util.List ���������õ�ʵ����:
 * 
 * java.util.ArrayList:ʹ������ʵ�֣���ѯЧ�ʸ���
 * java.util.LinkedList:����ʵ�֣���ɾԪ��Ч�ʸ���
 * 
 * List���˿��ظ�֮�⣬����һ���ص����������List
 * �����ṩ��һ��ͨ���±����Ԫ�صķ���
 * 
 * @author ta
 *
 */
public class ListDemo1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);
		/*
		 * E get(int index)
		 * ���ص�ǰ������ָ���±��Ӧ��Ԫ��
		 */
		String str = list.get(2);
		System.out.println(str);
		
		/*
		 * ��ͨ��forѭ�����Ա���List����
		 */
		for(int i=0;i<list.size();i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		
		/*
		 * E set(int index,E e)
		 * ������Ԫ�����õ�����ָ��λ�á�����ֵΪ
		 * ��λ�ö�Ӧ��ԭԪ��
		 */
		//[one,2,three,four]
		String old = list.set(1, "2");
		System.out.println(list);
		System.out.println("old:"+old);
	}
}









