package collection;
/**
 * JDK5 �Ƴ�ʱ�Ƴ���һ������:��ǿ��forѭ��
 * Ҳ��Ϊ��ѭ����for each
 * ��ѭ����������ȡ����ͳѭ���Ĺ�������ֻ������������
 * ������ʹ�á�
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
		 * ��ѭ���Ǳ������Ͽɣ�������������Ͽɡ�
		 * �������ڱ���Դ����ʱ�Ὣ��ѭ�����������Ϊ
		 * ��ͨ��forѭ��������
		 */
		for(String str:array) {
			System.out.println(str);
		}
	}
}








