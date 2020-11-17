package reflect;

import java.lang.reflect.Method;

/**
 * java 反射机制
 * 
 * 反射是一种动态机制，使用它可以在程序运行期间获取
 * 一个类的各项信息，调用方法，实例化等。
 * 使用反射可以提高代码灵活度，但是换来的是更多的性
 * 能开销。所以反射要适度使用。
 * 
 * 
 * Class类
 * 类对象，它的每一个实例用于表示JVM加载的一个类。
 * 并且在JVM内部，每个被加载的类有且只有一个类对象。
 * 通过类对象可以得知其表示的类的一切信息(类名，有
 * 哪些方法，属性，构造器等。)，并且可以快速实例化
 * 该类的实例。
 * 
 * 获取一个类的类对象有三种方式:
 * 1:直接调用该类的静态属性class得到。这种方式不灵
 *   活，但是当确定要调用某个类的类对象时可以使用。
 *   如:
 *   Class cls = String.class;
 *   Class cls = ArrayList.class;
 *   Class cls = int.class;
 *   
 * 2:使用Class的静态方法forName加载
 *   Class cls = Class.forName("java.lang.String");
 *   
 * 3:使用类加载器ClassLoader    
 * 
 * @author ta
 *
 */
public class ReflectDemo1 {
	public static void main(String[] args) throws ClassNotFoundException {
		/*
		 * 获取String的类对象
		 */
		Class cls = Class.forName("java.lang.String");
//		Class cls = String.class;
		
		/*
		 * java.lang.String
		 * java.util.ArrayList
		 * java.util.HashMap
		 */
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("请输入要加载的类名:");
//		String className = scanner.nextLine();
//		Class cls = Class.forName(className);
		/*
		 * 获取Class表示的类的名字
		 */
		String name = cls.getName();
		System.out.println(name);
		
		/*
		 * 获取该类的所有方法
		 * Method类的每个实例用于表示一个具体的方法
		 */
		Method[] methods = cls.getMethods();
		for(Method m : methods) {
			System.out.println(m.getName());
		}

	}
}








