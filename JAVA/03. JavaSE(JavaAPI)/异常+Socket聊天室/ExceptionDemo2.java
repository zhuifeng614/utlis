package exception;
/**
 * finally��
 * 
 * finally�����쳣������Ƶ����һ�飬����ֱ�Ӹ���
 * try��֮��������һ��catch֮��
 * 
 * finally�����ȷ��ֻҪ����ִ�е�try���У�����try
 * �鵱�еĴ����Ƿ��׳��쳣��finally���еĴ��붼�ض�
 * ִ�С�
 * 
 * ͨ�����ǽ��ͷ���Դ�����Ĳ�������finally��ȷ��ִ�У�
 * ����IO�йر����Ĳ�����
 * 
 * 
 * @author ta
 *
 */
public class ExceptionDemo2 {
	public static void main(String[] args) {
		System.out.println("����ʼ��");
		
		try {
			String str = "";
			System.out.println(str.length());
			return;
		} catch (Exception e) {
			System.out.println("������!");
		} finally {
			System.out.println("finally����ִ����");
		}		
			
		System.out.println("���������");
	}
}














