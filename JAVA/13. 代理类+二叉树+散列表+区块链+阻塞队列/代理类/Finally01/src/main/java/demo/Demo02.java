package demo;

public class Demo02 {

	public static void main(String[] args) {
		/**
		 * 如下代码创建了几个对象（不准确）
		 * 如下代码创建了几个字符串对象（准确）
		 * 准确回答：如下代码创建了2两个“字符串”对象！
		 */
		String s = "ABC";
		String ss = "A"+"BC";
		String s2 = 'A'+'B'+"C"; 
		String str = new String("AB"+"C"); 
		System.out.println(str); 
	}

}







