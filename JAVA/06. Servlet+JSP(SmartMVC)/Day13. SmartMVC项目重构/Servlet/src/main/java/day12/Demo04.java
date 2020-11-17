package day12;

import java.util.Scanner;

public class Demo04 {

	public static void main(String[] args)
		throws Exception {
		/**
		 * 动态加载类，动态创建对象
		 * 运行期间才加载类，创建对象
		 */
		Scanner in = new Scanner(System.in);
		System.out.print("输入类名：");
		String className = in.nextLine();
		//根据类名className动态加载类
		//如果类名错误，会出现类没有找到异常
		Class cls = Class.forName(className);
		System.out.println(cls);
		//动态创建 cls 对应的对象，cls必须包含无参数构造器
		//如果没有无参数构造器，则抛出 无此方法异常
		Object obj = cls.newInstance();
		System.out.println(obj); 
	}

}







