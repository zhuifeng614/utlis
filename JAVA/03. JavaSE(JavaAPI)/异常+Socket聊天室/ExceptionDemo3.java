package exception;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 在IO操作中使用异常处理机制
 * @author ta
 *
 */
public class ExceptionDemo3 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("fos.txt");			
			fos.write(1);	
		} catch (IOException e) {
			System.out.println("出错了!");
		} finally {
			try {
				if(fos!=null) {
					fos.close();
				}
			} catch (IOException e) {
				
			}
		}
		
	}
}







