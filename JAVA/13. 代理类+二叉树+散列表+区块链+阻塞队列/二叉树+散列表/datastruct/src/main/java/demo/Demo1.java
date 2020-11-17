package demo;

import java.util.Arrays;

public class Demo1 {
	/**
	 * 统计一个字符串中大写字母各自出现的次数。
	 * "ASDFAAxfas小张asdfH"
	 * 
	 *   char类型当作一个整数来看待(
	 *   unicode编码),也就是说，可以对
	 *   char类型进行计算。
	 *   
	 */
	public static void test1() {
		String str = "ASDFAAxfas小张asdfH";
		int[] arr = new int[26];
		for(int i = 0; i <str.length(); i++) {
			char c = str.charAt(i);
			//看该字符是否为大写字母
			if(c >= 'A' && c <= 'Z') {
				arr[c - 'A'] ++;
			}
		}
		char ch = 'A';
		for(int num :arr) {
			System.out.println(
					ch ++ + ":" + num);
		}
		
	}

	public static void main(String[] args) {
		test1();
		//字符是一个数字，其值是unicode编码
		char c = 0x90ed;
		System.out.println(c);
	}

}
