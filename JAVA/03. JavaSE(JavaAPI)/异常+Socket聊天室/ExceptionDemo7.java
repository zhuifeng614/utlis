package exception;
/**
 * �쳣���÷���
 * @author ta
 *
 */
public class ExceptionDemo7 {
	public static void main(String[] args) {
		System.out.println("����ʼ��");
		try {
			String str = "a";
			System.out.println(Integer.parseInt(str));
		} catch (Exception e) {
			System.out.println("������!");
			//��������ջ��Ϣ�����ڵ��Դ���
			e.printStackTrace();
			
			//��ȡ������Ϣ
			String message = e.getMessage();
			System.out.println("message:"+message);
		}	
		System.out.println("���������");
		
	}
}



