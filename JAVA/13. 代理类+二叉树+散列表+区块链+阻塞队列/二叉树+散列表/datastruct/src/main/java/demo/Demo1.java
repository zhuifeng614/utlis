package demo;

import java.util.Arrays;

public class Demo1 {
	/**
	 * ͳ��һ���ַ����д�д��ĸ���Գ��ֵĴ�����
	 * "ASDFAAxfasС��asdfH"
	 * 
	 *   char���͵���һ������������(
	 *   unicode����),Ҳ����˵�����Զ�
	 *   char���ͽ��м��㡣
	 *   
	 */
	public static void test1() {
		String str = "ASDFAAxfasС��asdfH";
		int[] arr = new int[26];
		for(int i = 0; i <str.length(); i++) {
			char c = str.charAt(i);
			//�����ַ��Ƿ�Ϊ��д��ĸ
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
		//�ַ���һ�����֣���ֵ��unicode����
		char c = 0x90ed;
		System.out.println(c);
	}

}
