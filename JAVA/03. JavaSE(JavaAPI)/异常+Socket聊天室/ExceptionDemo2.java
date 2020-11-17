package exception;
/**
 * finally块
 * 
 * finally块是异常处理机制的最后一块，可以直接跟在
 * try块之后或者最后一个catch之后。
 * 
 * finally块可以确保只要代码执行到try当中，无论try
 * 块当中的代码是否抛出异常，finally块中的代码都必定
 * 执行。
 * 
 * 通常我们将释放资源这样的操作放在finally中确保执行，
 * 比如IO中关闭流的操作。
 * 
 * 
 * @author ta
 *
 */
public class ExceptionDemo2 {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		
		try {
			String str = "";
			System.out.println(str.length());
			return;
		} catch (Exception e) {
			System.out.println("出错了!");
		} finally {
			System.out.println("finally代码执行了");
		}		
			
		System.out.println("程序结束了");
	}
}














