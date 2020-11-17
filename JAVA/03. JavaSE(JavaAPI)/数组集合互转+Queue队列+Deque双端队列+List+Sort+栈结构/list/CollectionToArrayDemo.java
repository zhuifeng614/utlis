package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * ����ת��Ϊ����
 * 
 * Collection�ṩ��һ������:toArray,���Խ���ǰ����
 * ת��Ϊһ������
 * @author ta
 *
 */
public class CollectionToArrayDemo {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<>();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		System.out.println(c);
		
//		Object[] array = c.toArray();
		
		String[] array 
			= c.toArray(new String[c.size()]);
		System.out.println(array.length);
		System.out.println(Arrays.toString(array));
		
	}
}







