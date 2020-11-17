package cn.tedu;

public class Demo02 {

	public static void main(String[] args) {
		/*
		 * Java 7 开始支持0b开头的2进制直接量
		 * 
		 */
		int n = 0b1110110100111110100111111;
		
		/*
		 * 可以利用16进制作为2进制的简写形式 
		 */
		n = 0x77d27d77;
		System.out.println(
				Integer.toBinaryString(n));
		n = 0423;
		
		long l = 0x67abdf122122L;
	}

}



