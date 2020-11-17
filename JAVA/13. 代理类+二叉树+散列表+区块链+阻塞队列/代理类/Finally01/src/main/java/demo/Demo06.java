package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo06 {
	public static List<String> list=
			new CopyOnWriteArrayList<String>();
	public static void main(String[] args) {
		/**
		 * ArrayList 的并发修改异常
		 * 
		 * CopyOnWriteArrayList 是线程安全的集合
		 * 同时因为其在遍历时候克隆了一个副本，
		 * 对副本进行遍历，修改时候修改的是原集合，
		 * 这样可以避免 并发修改异常。
		 * 
		 */
		list.add("Tom");
		list.add("Jerry");
		list.add("Andy");
		list.add("Mac");
		list.add("Nemo");
		
		Thread t1 = new Thread() {
			public void run() {
				for (String s : list) {
					System.out.println(s);
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				String s = list.remove(0);
				System.out.println(s); 
			}
		};
		t1.start();
		t2.start();
	}

}
