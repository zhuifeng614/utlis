package demo;

import java.util.Arrays;

/**
 * ��ʾbinarySearch(���ֲ���)������ʹ��
 *
 */
public class Demo2 {

	public static void main(String[] args) {
		int[] arr = {2,3,3,11,26,33,128,888};
		int index = 
				Arrays.binarySearch(arr, 33);
		System.out.println("index:" + index);
		
		/*
		 * ����Ҳ�����ֵ���򷵻�
		 *    -index - 1��
		 *    
		 */
		int index2 = 
				Arrays.binarySearch(arr, 28);
		System.out.println("index2:" + index2);
		
		int index3 = 
				Arrays.binarySearch(arr, 999);
		System.out.println("index3:" + index3);
		
		/*
		 * ������ظ�Ԫ�أ��򷵻���������һ��Ԫ��
		 * ��λ�á�
		 */
		int index4 = 
				Arrays.binarySearch(arr, 3);
		System.out.println("index4:" + index4);
		
		int[] arr2 = {11,12,33,66,88};
		int index5 = 
				Arrays.binarySearch(arr2, 8);
		System.out.println(
				"index5:"+ index5);
		
	}

}




