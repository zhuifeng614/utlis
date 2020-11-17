package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * ���ϲ���
 * @author ta
 *
 */
public class CollectionDemo5 {
	public static void main(String[] args) {
		Collection c1 = new ArrayList();
		c1.add("java");
		c1.add("c");
		c1.add("c++");
		System.out.println("c1:"+c1);
		
		Collection c2 = new HashSet();
		c2.add("php");
		c2.add("ios");
		c2.add("java");
		System.out.println("c2:"+c2);
		/*
		 * boolean addAll(Collection c)
		 * �����������е�����Ԫ����ӵ���ǰ�����С�
		 * ��Ӻ�ǰ����Ԫ�ط����仯�򷵻�true��
		 */
		c1.addAll(c2);
		System.out.println("c1:"+c1);
		
		
		Collection c3 = new ArrayList();
		c3.add("php");
		c3.add("c++");
		c3.add("android");
		/*
		 * boolean containsAll(Collection c)
		 * �жϵ�ǰ�����Ƿ�����������ϵ�����Ԫ��
		 */
		boolean contains = c1.containsAll(c3);
		System.out.println("ȫ����:"+contains);
		
		/*
		 * ɾ����ǰ��������������ϵĹ���Ԫ�ء�
		 */
		c1.removeAll(c3);
		System.out.println("c1:"+c1);
		
	}
}











