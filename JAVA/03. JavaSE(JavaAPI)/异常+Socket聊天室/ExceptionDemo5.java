package exception;
/**
 * 异常的抛出
 * 使用throw关键字可以将一个异常抛出。通常如下情况
 * 我们会主动对外抛出异常:
 * 1:程序执行中发现一个满足语法要求，但是不满足业务逻
 *   辑要求的情况时可以对外抛出异常告知不应当这样做。
 *   
 * 2:程序确实出现了异常，但是该异常不应当在当前代码片
 *   段中被解决时可以对外抛出给调用者解决(责任制问题)   
 * 
 * @author ta
 *
 */
public class ExceptionDemo5 {
	public static void main(String[] args) {
		Person p = new Person();
		/*
		 * 满足语法要求，程序可以运行，但是这实际上
		 * 已经不满足业务需求.
		 */
		try {
			/*
			 * 当我们调用一个含有throws声明异常抛出
			 * 的方法时，编译器要求我们必须处理这个
			 * 异常，否则编译不通过。
			 * 处理异常的方式有两种:
			 * 1:使用try-catch捕获并处理这个异常
			 * 2:在当前方法上继续使用throws将这个
			 *   异常抛出
			 * 具体选择哪种解决方式取决于处理异常的
			 * 责任问题。  
			 */
			p.setAge(1000);
		} catch (IllegalAgeException e) {
			System.out.println("出错了!");
		}
		System.out.println("年龄是:"+p.getAge());
	}
}







