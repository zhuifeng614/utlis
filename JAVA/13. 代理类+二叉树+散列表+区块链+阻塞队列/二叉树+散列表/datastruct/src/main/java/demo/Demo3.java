package demo;

import java.util.Arrays;
import java.util.Random;

public class Demo3 {
	
	/**
	 * ���ǳ�������һ��������ǰ100���ҵ�
	 * ��100�������У��ҳ�����ǰ�������֡�
	 * ԭ������ͬ�ġ�
	 */
	public static void main(String[] args) {
		
		Random r = new Random();
		//arr�����������ǰ��������
		int[] arr = new int[5];
		
		for(int i = 0; i < 100; i ++) {
			//ģ������һЩ����
			int number = r.nextInt(1000);
			/*
			 * ��number�����鵱�е��±ꡣ
			 * ����ҵ��ˣ�����ʵ�ʵ�λ��,
			 * �Ҳ��������� -index - 1��
			 */
			int index = 
					Arrays.binarySearch(
							arr, number);
			/*
			 * number�ȵ�ǰ���鵱�е�����Ԫ��
			 * С������ȣ����numberû�б�Ҫ
			 * �ӽ�����
			 */
			if(index == 0 || index == -1) {
				continue;
			}
			/*
			 * ���index < 0,û���ҵ���
			 * ��index��ԭ
			 */
			if(index < 0) {
				index = -(index + 1);
			}
			
			for(int j = 1; j < index; j++) {
				arr[j - 1] = arr[j];
			}
			
			arr[index - 1] = number;
			System.out.println(
					Arrays.toString(arr));
		}
		System.out.println(
				Arrays.toString(arr));
	}

}
