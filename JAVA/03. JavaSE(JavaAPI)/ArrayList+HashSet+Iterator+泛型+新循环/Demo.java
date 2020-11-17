package collection;

import java.util.ArrayList;
import java.util.Collection;

public class Demo {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		Point p = new Point(1,2);
		String s = "hello";
		int a = 1;
		test(a,s,p,c);
		System.out.println("c:"+c);//?
		System.out.println("p:"+p);//?
		System.out.println("s:"+s);//?
		System.out.println("a:"+a);//?
	}
	
	public static void test(int a,String s,Point p,Collection c) {
		a++;
		s = s+"world";
		p.setX(2);
		c.clear();
		p = new Point(3,4);
		c.add(p);
		p.setX(5);
		c = new ArrayList();
		p = new Point(7,8);
		c.add(p);
		s = "thinking in java";
		p.setX(a);
	}
}




