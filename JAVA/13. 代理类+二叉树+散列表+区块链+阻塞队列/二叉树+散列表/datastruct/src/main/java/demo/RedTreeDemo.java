package demo;

import java.util.TreeSet;

/**
 * 
 * 　演示红黑树的规则
 * 	红黑树的规则:
 *	a.节点可以是红色的或者是黑色的。
 *	b.根节点必须是黑色的。
 *	c.叶子节点必须是黑色的。
 *	d.红色节点的子节点必须是黑色的。
 *	e.从根节点到任何叶子节点的路径上，
 *	包含的黑色节点的个数是一样的。
 */
public class RedTreeDemo {
	public static void main(String[] args) {
		/*
		 * TreeSet是Set接口的一个实现类。
		 * 该类内部采用了红黑树的算法。
		 */
		TreeSet<Integer> ts = 
				new TreeSet<Integer>();
		ts.add(80);
		ts.add(60);
		ts.add(40);
		ts.add(30);
		
		
	}

}
