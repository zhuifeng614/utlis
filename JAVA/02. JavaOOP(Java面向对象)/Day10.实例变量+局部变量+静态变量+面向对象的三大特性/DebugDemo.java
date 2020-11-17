package oo.day10;
//Debugµ÷ÊÔ¹¤¾ß
public class DebugDemo {
	public static void main(String[] args) {
		int num1 = 5;
		int num2 = 6;
		test(num1,num2);
		System.out.println("over");
	}
	
	public static void test(int a,int b) {
		int c = a+b;
		if(c>10) {
			System.out.println(c);
		}
	}
}




















