package lambda;
/**
 * lambda���ʽ
 * 
 * ����ʹ�ø������﷨���������ڲ���
 * 
 * �﷨:
 * (�����б�)->{
 * 	������
 * }
 * 
 * ʹ��lambda����ʱ����ʵ�ֵĽӿ�ֻ����һ�����󷽷�
 * 
 * @author ta
 *
 */
public class LambdaDemo1 {
	public static void main(String[] args) {
		Runnable r1 = new Runnable() {
			public void run() {
				System.out.println("hello");
			}
		};
		
		Runnable r2 = ()->{
			System.out.println("hello");
		};
		/*
		 * ���������ֻ��һ����룬��ô�÷�����{}
		 * ����ʡ�Բ�д��
		 */
		Runnable r3 
			= ()->System.out.println("hello");
		

	}
}









