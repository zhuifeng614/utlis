package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * JDK5 �Ƴ�ʱ�Ƴ�����һ������:����
 * ����Ҳ��Ϊ���������ͣ�������ʹ��һ�����ʱ����
 * ĳ����������ָ������������Ե����ͣ����������򷵻�
 * ֵ�����͡��������ߴ�������ȡ�
 * 
 * ����Ӧ�����ĵط����Ǽ��ϣ�����ָ�������е�Ԫ������
 * @author ta
 *
 */
public class CollectionDemo7 {
	public static void main(String[] args) {
		/*
		 * ���͵�ʵ������ֻ��ָ���������ͣ���ϣ��ָ��
		 * ��������ʱ��Ҫָ�����Ӧ�İ�װ������
		 * Collection<Integer> c; ����
		 * Collection<int> c;     ���벻ͨ��
		 */
		Collection<String> c
				= new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
//		c.add(1); //���벻ͨ��
		System.out.println(c);
		/*
		 * ָ�������͵ļ��ϣ���ʹ����ѭ������ʱ����
		 * ֱ����ָ�������ͽ��ռ���Ԫ��
		 */
		for(String str : c) {
			System.out.println(str);
		}
		/*
		 * ������Ҳ֧�ַ��ͣ�ָ��ʱӦ����������ļ���
		 * ��������һ�¡�
		 */
		Iterator<String> it = c.iterator();
		while(it.hasNext()) {
			//��ȡԪ��ʱ����������
			String str = it.next();
			System.out.println(str);
		}
		
		
	}
}







