package demo;

import java.util.Arrays;
import java.util.Random;

public class Demo3 {
	
	/**
	 * 将非常大量的一组数据中前100名找到
	 * 从100个数当中，找出排名前５的数字。
	 * 原理是相同的。
	 */
	public static void main(String[] args) {
		
		Random r = new Random();
		//arr用来存放排名前５的数字
		int[] arr = new int[5];
		
		for(int i = 0; i < 100; i ++) {
			//模拟生成一些数字
			int number = r.nextInt(1000);
			/*
			 * 找number在数组当中的下标。
			 * 如果找到了，返回实际的位置,
			 * 找不到，返回 -index - 1。
			 */
			int index = 
					Arrays.binarySearch(
							arr, number);
			/*
			 * number比当前数组当中的所有元素
			 * 小或者相等，则该number没有必要
			 * 加进来。
			 */
			if(index == 0 || index == -1) {
				continue;
			}
			/*
			 * 如果index < 0,没有找到，
			 * 把index还原
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
