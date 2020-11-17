package lambda;
/**
 * lambda表达式
 * 
 * 可以使用更简洁的语法创建匿名内部类
 * 
 * 语法:
 * (参数列表)->{
 * 	方法体
 * }
 * 
 * 使用lambda创建时，其实现的接口只能有一个抽象方法
 * 
 * @author ta
 *
 */
public class LambdaDemo1 {
	public static void main(String[] args) {
		Runnable r1 = new Runnable() {
			public void run() {
				System.out.println("hello");
			}
		};
		
		Runnable r2 = ()->{
			System.out.println("hello");
		};
		/*
		 * 如果方法中只有一句代码，那么该方法的{}
		 * 可以省略不写。
		 */
		Runnable r3 
			= ()->System.out.println("hello");
		

	}
}









