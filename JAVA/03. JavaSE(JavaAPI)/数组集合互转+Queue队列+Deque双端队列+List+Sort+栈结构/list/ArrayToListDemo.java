package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ������ת��Ϊ����
 * 
 * ����Ĺ�����:java.util.Arrays�ṩ��һ����̬����
 * asList,���Խ�һ������ת��Ϊһ��List����
 * @author ta
 *
 */
public class ArrayToListDemo {
	public static void main(String[] args) {
		String[] array = {"one","two","three","four"};
		
		List<String> list = Arrays.asList(array);
		System.out.println(list.size());
		System.out.println(list);
		//�Լ���Ԫ�ز������Ƕ��������
		list.set(1, "2");
		System.out.println(list);
		System.out.println(Arrays.toString(array));
		
		//�������鶨������˼��ϲ�������ɾԪ��
//		list.add("five");//���׳���֧�ֲ������쳣
		
		//��ϣ����ɾԪ�أ������д���һ������
		List<String> list1 = new ArrayList<>(list);	
		System.out.println("list1:"+list1);
		list1.add("five");
		System.out.println("list1:"+list1);
	}
}







