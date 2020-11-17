package demo;

import java.util.HashMap;

/**
 * 	演示散列表的底层的一些细节知识
 *
 */
public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<String,Integer> map = 
				new HashMap<String,Integer>();
		
		map.put("Jerry", 1);
		map.put("Tom", 2);
		map.put("Tom",250);
		map.put("李白", 3);
		map.put("Sally", 4);
		map.put("大师兄", 5);
		map.put("熊大", 6);
		map.put("熊二", 7);
		map.put("光头强", 8);
		map.put("小七", 9);
		map.put("花千骨", 10);
		map.put("子画", 11);
		map.put("John", 12);
		map.put("小白", 13);
		map.put("如花", 14);
		
		
	}

}
