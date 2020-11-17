package demo;

import java.util.Arrays;

/**
 * 演示binarySearch(二分查找)方法的使用
 *
 */
public class Demo2 {

	public static void main(String[] args) {
		int[] arr = {2,3,3,11,26,33,128,888};
		int index = 
				Arrays.binarySearch(arr, 33);
		System.out.println("index:" + index);
		
		/*
		 * 如果找不到该值，则返回
		 *    -index - 1。
		 *    
		 */
		int index2 = 
				Arrays.binarySearch(arr, 28);
		System.out.println("index2:" + index2);
		
		int index3 = 
				Arrays.binarySearch(arr, 999);
		System.out.println("index3:" + index3);
		
		/*
		 * 如果有重复元素，则返回其中任意一个元素
		 * 的位置。
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




