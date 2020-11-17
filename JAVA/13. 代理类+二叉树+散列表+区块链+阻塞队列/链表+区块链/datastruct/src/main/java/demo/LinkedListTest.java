package demo;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<String> list = 
				new LinkedList<String>();
		list.add("Sally");
		list.add("哪吒");
		list.add("King");
		list.add("小白");
		list.add("花千骨");
		list.add("胡八一");
//		System.out.println("size:" 
//				+ list.size());
//		System.out.println("list:" + list);
//		
//		System.out.println("位置5:" 
//				+list.get(5));
		
//		System.out.println(list.remove(0));
//		System.out.println("list:" + list);
		
		list.add(0,"小月");
		System.out.println("list:" + list);
	}

}


