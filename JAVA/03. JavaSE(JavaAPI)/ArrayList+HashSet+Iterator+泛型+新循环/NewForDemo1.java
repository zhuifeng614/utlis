package collection;
/**
 * JDK5 推出时推出了一个特性:增强型for循环
 * 也称为新循环，for each
 * 新循环不是用来取代传统循环的工作，它只用来遍历集合
 * 或数组使用。
 * @author ta
 *
 */
public class NewForDemo1 {
	public static void main(String[] args) {
		String[] array = {"one","two","three","four"};
		
		for(int i=0;i<array.length;i++) {
			String str = array[i];
			System.out.println(str);
		}
		/*
		 * 新循环是编译器认可，而不是虚拟机认可。
		 * 编译器在编译源代码时会将新循环遍历数组改为
		 * 普通的for循环遍历。
		 */
		for(String str:array) {
			System.out.println(str);
		}
	}
}








