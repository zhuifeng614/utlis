package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * boolean contains(E e)
 * �жϼ����Ƿ��������Ԫ��
 * 
 * @author ta
 *
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Point(1,2));
		c.add(new Point(3,4));
		c.add(new Point(5,6));
		c.add(new Point(7,8));
		System.out.println(c);
		
		Point p = new Point(1,2);
		/*
		 * �����жϰ����ı�׼�ǣ�ֻҪ�����е�Ԫ����
		 * ���������Ԫ����equals�Ƚ�Ϊtrue�����
		 * ����Ϊ������
		 */
		boolean contains = c.contains(p);
		System.out.println("����:"+contains);
	}
}







