package cn.tedu;

public class Demo01 {

	public static void main(String[] args) {
		/**
		 * 2������ʾ
		 */
		int n = 50; //110010
		//110010 Integer.toString() "50"
		System.out.println(n); //"50"
		//Integer.toBinaryString ���������ڴ��е�2
		// ���ƴ洢���ת��Ϊ�ַ�����������ʾ
		System.out.println(Integer.toBinaryString(n));
		for(int i=0; i<=100; i++) {
			System.out.println(
					Integer.toBinaryString(i));
		}
		
		
	}
}








