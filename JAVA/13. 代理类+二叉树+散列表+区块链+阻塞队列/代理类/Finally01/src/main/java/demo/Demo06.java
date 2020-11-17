package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo06 {
	public static List<String> list=
			new CopyOnWriteArrayList<String>();
	public static void main(String[] args) {
		/**
		 * ArrayList �Ĳ����޸��쳣
		 * 
		 * CopyOnWriteArrayList ���̰߳�ȫ�ļ���
		 * ͬʱ��Ϊ���ڱ���ʱ���¡��һ��������
		 * �Ը������б������޸�ʱ���޸ĵ���ԭ���ϣ�
		 * �������Ա��� �����޸��쳣��
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
