package cn.tedu;

public class Demo01 {

	public static void main(String[] args) {
		/**
		 * 2进制演示
		 */
		int n = 50; //110010
		//110010 Integer.toString() "50"
		System.out.println(n); //"50"
		//Integer.toBinaryString 将整数在内存中的2
		// 进制存储情况转换为字符串，用于显示
		System.out.println(Integer.toBinaryString(n));
		for(int i=0; i<=100; i++) {
			System.out.println(
					Integer.toBinaryString(i));
		}
		
		
	}
}








