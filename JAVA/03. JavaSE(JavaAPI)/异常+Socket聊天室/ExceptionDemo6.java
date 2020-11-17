package exception;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 重写超类含有throws声明异常抛出的方法时对throws
 * 的重写规则
 * @author ta
 *
 */
public class ExceptionDemo6 {
	public void dosome()
			throws IOException,AWTException {
		
	}
}

class Son extends ExceptionDemo6{
//	public void dosome()
//			throws IOException,AWTException {
//		
//	}
	
	//允许不再抛出任何异常
//	public void dosome(){
//		
//	}
	
	//允许仅抛出部分异常
//	public void dosome()
//			throws IOException{
//		
//	}
	
	//允许抛出超类方法抛出异常的子类型异常
//	public void dosome()
//			throws FileNotFoundException {
//		
//	}
	
	//不允许抛出额外异常
//	public void dosome()
//			throws SQLException {
//		
//	}
	
	//不允许抛出超类方法抛出异常的父类异常
//	public void dosome()
//			throws Exception {
//		
//	}
}








