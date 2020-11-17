package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * java���Ͽ��
 * ����������һ����������������һ�����ݵģ����Ǽ�����
 * ���˲���Ԫ�ص���ط�����ʹ�ø����㣬���Ҽ����ж���
 * ��ͬ�����ݽṹʵ�֡�
 * 
 * java.util.Collection �ӿ�
 * java�����еļ��϶��Ǹýӿڵ�ʵ���࣬�����������м���
 * ��Ӧ���߱��Ĺ���(�����ȡԪ�صȵ�)
 * 
 * Collection���泣���ӽӿ�:
 * java.util.List:���ظ����ϣ���������
 * java.util.Set:�����ظ�����
 * ��ָ���ظ���Ԫ���Ƿ��ظ������ظ����ж�����������Ԫ��
 * ����equals�ȽϵĽ����Set���ϲ�������equals�Ƚ�Ϊ
 * true��Ԫ�����Ρ�
 * 
 * @author ta
 *
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		/*
		 * boolean add(E e)
		 * ��ǰ��������Ӹ���Ԫ�أ��ɹ������
		 * ����true,���򷵻�false
		 */
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		c.add("five");
		System.out.println(c);
		/*
		 * int size()
		 * ���ص�ǰ���ϵ�Ԫ�ظ���
		 */
		int size = c.size();
		System.out.println("size:"+size);
		/*
		 * boolean isEmpty()
		 * �жϵ�ǰ�����Ƿ�Ϊ�ռ�(sizeΪ0ʱ�ǿռ�)
		 */
		boolean isEmpty = c.isEmpty();
		System.out.println("�Ƿ�Ϊ�ռ�:"+isEmpty);
		
		//��ռ���
		c.clear();
		System.out.println("��ռ���");
		
		System.out.println(c);
		System.out.println("size:"+c.size());
		System.out.println("�Ƿ�Ϊ�ռ�:"+c.isEmpty());
	}
}









