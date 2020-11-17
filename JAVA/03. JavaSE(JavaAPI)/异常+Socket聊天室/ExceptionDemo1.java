package exception;
/**
 * �쳣��������е�try-catch
 * �﷨:
 * try{
 * 	����Ƭ��
 * }catch(XXXException e){
 * 	����try�г��ֵ�XXXException�Ĵ���Ƭ��
 * }
 * 
 * @author ta
 *
 */
public class ExceptionDemo1 {
	public static void main(String[] args) {
		System.out.println("����ʼ��");
		try {
			String str = "a";
			/*
			 * ���������쳣ʱ��JVM��ʵ�������쳣��
			 * ʵ���������׳���
			 */
			System.out.println(str.length());
			
			System.out.println(str.charAt(0));
			
			System.out.println(Integer.parseInt(str));
			/*
			 * ��try�б���������µ����ݾ�����ִ��
			 */
			System.out.println("!!!!!");
		}catch(NullPointerException e) {
			System.out.println("�����˿�ָ��!");
		
		}catch(StringIndexOutOfBoundsException e) {
			System.out.println("�ַ����±�Խ����!");
		/*
		 * catch�ǿ��Զ������ģ�����Բ�ͬ���쳣
		 * �����в�ͬ�Ĵ����ֶ�ʱ�����ǿ��Էֱ𲶻���Щ
		 * �쳣������
		 * ��Ӧ����һ����ϰ�ߣ������һ��catch�в���
		 * Exception�����Է�ֹ��Ϊһ��δ������쳣����
		 * �����жϡ�
		 */
		}catch(Exception e) {
			System.out.println("�������ǳ��˸���!");
		}
		
		System.out.println("���������");
	}
}








