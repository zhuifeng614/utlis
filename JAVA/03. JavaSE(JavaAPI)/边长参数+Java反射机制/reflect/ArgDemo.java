package reflect;
/**
 * �䳤����
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
	 * �䳤������һ��������ֻ�ܶ���һ��������ֻ����Ϊ
	 * ���������һ������ʹ�á�
	 * �߳��������ʾ���һ�����顣
	 * @param s
	 */
	public static void dosome(String... s) {
		System.out.println(s.length);
	}
}









