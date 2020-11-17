package exception;
/**
 * 异常处理机制中的try-catch
 * 语法:
 * try{
 * 	代码片段
 * }catch(XXXException e){
 * 	处理try中出现的XXXException的代码片段
 * }
 * 
 * @author ta
 *
 */
public class ExceptionDemo1 {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		try {
			String str = "a";
			/*
			 * 当出现了异常时，JVM会实例化该异常的
			 * 实例并将其抛出。
			 */
			System.out.println(str.length());
			
			System.out.println(str.charAt(0));
			
			System.out.println(Integer.parseInt(str));
			/*
			 * 在try中报错代码以下的内容均不会执行
			 */
			System.out.println("!!!!!");
		}catch(NullPointerException e) {
			System.out.println("出现了空指针!");
		
		}catch(StringIndexOutOfBoundsException e) {
			System.out.println("字符串下标越界了!");
		/*
		 * catch是可以定义多个的，当针对不同的异常
		 * 我们有不同的处理手段时，我们可以分别捕获这些
		 * 异常并处理。
		 * 但应当有一个好习惯，在最后一个catch中捕获
		 * Exception，可以防止因为一个未处理的异常导致
		 * 程序中断。
		 */
		}catch(Exception e) {
			System.out.println("反正就是出了个错!");
		}
		
		System.out.println("程序结束了");
	}
}








