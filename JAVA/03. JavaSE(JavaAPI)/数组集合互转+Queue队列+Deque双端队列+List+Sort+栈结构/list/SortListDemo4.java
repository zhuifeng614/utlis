package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * �����ַ���
 * @author ta
 *
 */
public class SortListDemo4 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("����ʦ");
		list.add("����");
		list.add("С����ʦ");	
		System.out.println(list);
		/*
		 * �ַ���Ҳʵ����Comparable�ӿڣ�����ıȽ�
		 * �����ǰ����ַ���unicode�����С���󣬵���
		 * �������ľ�ûʲô�����ˡ�
		 */
		Collections.sort(list);
		System.out.println(list);
		
		//�����ַ���������
		Collections.sort(list,new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}	
		});
		System.out.println(list);
	}
}





