package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * �����к��в���
 * @author ta
 *
 */
public class LambdaDemo2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("����ʦ");
		list.add("����");
		list.add("С����ʦ");
		System.out.println(list);
		

		Collections.sort(list,new Comparator<String>(){
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
		});
		System.out.println(list);
		/*
		 * ��������ָ�����ͣ�����������ݳ���������
		 * �������������ͣ�������ȷ��ʱ��Ҫָ��(������벻ͨ��)
		 */
//		Collections.sort(list,(o1,o2)->{
//			return o2.length()-o1.length();
//		});
		
		/*
		 * ������Ժ���{}����ô�����е�return�ؼ���
		 * ҲҪ����
		 */
		Collections.sort(list,
			(o1,o2)->o2.length()-o1.length()
		);
		System.out.println(list);
		
	}
}








