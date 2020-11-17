package list;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ȡ�Ӽ�
 * @author ta
 *
 */
public class ListDemo3 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<10;i++) {
			list.add(i);
		}
		System.out.println(list);
		
		//��ȡ[3-7]
		List<Integer> subList = list.subList(3, 8);
		System.out.println(subList);
		
		/*
		 * ���Ӽ�ÿ��Ԫ������10��
		 * [30,40,50,60,70]
		 */
		for(int i=0;i<subList.size();i++) {
			int num = subList.get(i);
			num = num * 10;
			subList.set(i, num);
		}
		System.out.println(subList);
		/*
		 * ���Ӽ��Ĳ������Ƕ�ԭ���϶�ӦԪ�صĲ���
		 */
		System.out.println(list);
		
		//ɾ��2-8
		list.subList(2, 9).clear();
		System.out.println(list);
	}
}






