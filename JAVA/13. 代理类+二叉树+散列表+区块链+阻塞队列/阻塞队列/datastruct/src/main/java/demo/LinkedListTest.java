package demo;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<String> list = 
				new LinkedList<String>();
		list.add("Sally");
		list.add("��߸");
		list.add("King");
		list.add("С��");
		list.add("��ǧ��");
		list.add("����һ");
//		System.out.println("size:" 
//				+ list.size());
//		System.out.println("list:" + list);
//		
//		System.out.println("λ��5:" 
//				+list.get(5));
		
//		System.out.println(list.remove(0));
//		System.out.println("list:" + list);
		
		list.add(0,"С��");
		System.out.println("list:" + list);
	}

}


