package collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * ���ϵı���
 * Iterator iterator()
 * �÷������Ի�ȡһ�����ڱ�����ǰ���ϵĵ�����ʵ����
 * ͨ��Iterator�Ϳ��Ա�������Ԫ���ˡ�
 * 
 * java.util.Iterator�ӿ�
 * �ýӿڹ涨�����е�����ʵ����������ϵ�ͨ�ò�������
 * ������������ѭ�Ĳ���Ϊ:�ʣ�ȡ��ɾ
 * ����ɾ��Ԫ�ز��Ǳ�Ҫ������
 * 
 * ��ͬ�ļ��϶��ṩ��һ��Iterator��ʵ���࣬��������
 * ��ס��Щʵ��������֣���Iterator�ӿڽ��ղ�����
 * �����������ɡ�
 * 
 * @author ta
 *
 */
public class CollectionDemo6 {
	public static void main(String[] args) {
		Collection c = new HashSet();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		c.add("#");
		c.add("five");
		System.out.println(c);
		
		Iterator it = c.iterator();
		/*
		 * boolean hasNext()
		 * ͨ���������жϼ����Ƿ���Ԫ�ؿ��Ա���
		 */
		while(it.hasNext()) {
			/*
			 * E next()
			 * ��ȡ������һ��Ԫ��
			 */
			String str = (String)it.next();
			System.out.println(str);
			if("#".equals(str)) {
				/*
				 * ����������������һ��Ҫ�󣬱���
				 * �Ĺ����в���ͨ�����ϵķ�����ɾ
				 * Ԫ�أ�������׳��쳣
				 */
//				c.remove(str);
				/*
				 * ��������remove��������Ҫ���Σ�
				 * ɾ���ľ��Ǳ��α���ʱnext()�õ���
				 * Ԫ��
				 */
				it.remove();
			}
		}
		System.out.println(c);
	}
}














