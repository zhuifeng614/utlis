package exception;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JDK7推出时，推出了一个特性:自动关闭 AutoCloseable
 * 
 * @author ta
 *
 */
public class ExceptionDemo4 {
	public static void main(String[] args) {
		/*
		 * 注意,try后面圆括号中定义的内容都必须实现了
		 * AutoCloseable接口。
		 * 这个特性是编译器认可的，编译器在编译当前源代
		 * 码时会将这里定义的内容最终改为在finally中关闭
		 */
		try(
			FileOutputStream fos
				= new FileOutputStream("fos.txt");	
		){
			fos.write(1);
		}catch(IOException e) {
			System.out.println("出错了!");
		}
	}
}






