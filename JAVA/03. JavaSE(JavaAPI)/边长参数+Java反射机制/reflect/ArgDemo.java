package reflect;
/**
 * 变长参数
 * 
 * @author ta
 *
 */
public class ArgDemo {
	public static void main(String[] args) {
		
		dosome("one");
		
		dosome("one","two");
		
		dosome("one","two","three");
		
		dosome("one","two","three","two","three","two","three","two","three","two","three","two","three","two","three","two","three");
	}
	/**
	 * 变长参数在一个方法中只能定义一个，并且只能作为
	 * 方法的最后一个参数使用。
	 * 边长参数本质就是一个数组。
	 * @param s
	 */
	public static void dosome(String... s) {
		System.out.println(s.length);
	}
}









