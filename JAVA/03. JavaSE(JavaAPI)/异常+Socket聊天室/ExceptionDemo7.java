package exception;
/**
 * 异常常用方法
 * @author ta
 *
 */
public class ExceptionDemo7 {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		try {
			String str = "a";
			System.out.println(Integer.parseInt(str));
		} catch (Exception e) {
			System.out.println("出错了!");
			//输出错误堆栈信息，便于调试代码
			e.printStackTrace();
			
			//获取错误消息
			String message = e.getMessage();
			System.out.println("message:"+message);
		}	
		System.out.println("程序结束了");
		
	}
}



