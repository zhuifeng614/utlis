package demo;

public class Demo01 {

	public static void main(String[] args) {
		/**
		 * ����ת��
		 * ��7���ơ�123��ת��Ϊ10���� (��׼ȷ)
		 * ��7���ơ�123��ת��Ϊint���� (רҵ׼ȷ)
		 */
		String num = "123";
		int n = Integer.parseInt(num, 6);
		System.out.println(n); 
		
		//����������Ŀ:  �������
		// int k = 078;
		// System.out.println(k);
		// A.78 B.79 C.������� D.�����쳣
		
		char c = 0x7fa4;
		c--;
		System.out.println(c); 
		System.out.println(parseInt(num, 6));  
		
 
		
		int a = '0'; //48
		System.out.println(a);
		a = '1'; 
		System.out.println(a);
		a = '2';
		System.out.println(a);
		a = '3'; //51
		System.out.println(a);
		a = '4';
		System.out.println(a);
		
		System.out.println('3'-'0'); //51-48=3
		
		System.out.println('3'*'0'); 
 		
	}
	
	public static int parseInt(String num, int base) {
		int sum = 0;
		int weight = 1;
		for(int i=num.length()-1; i>=0; i--) {
			char ch = num.charAt(i);
			int n = ch - '0';
			if(!(0<=n && n<base)) {
				throw new NumberFormatException(num);
			}
			sum += n * weight;
			weight *= base;
		}
		return sum;
	}

}






