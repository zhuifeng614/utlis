package demo;

public class Demo07 {

	public static void main(String[] args) {
		int a = 5;//a��ֵ��5
		int[] arr = new int[] {5};
		//���ñ���arr������ֵ�Ƕ�����׵�ַ
		//��Ϊ���ñ������ݺ�������ͬһ������
		//��� main������test����������ͬһ������
		//������test�������޸Ķ����൱��ҲӰ����main
		//main�����й���Ķ���
		test(a, arr);
		System.out.println(a);//5
		System.out.println(arr[0]);//6
	}
	public static void test(int a, int[] arr) {
		//������������ʱ�� ��ԭa��ֵ������һ�ݸ�a
		//arr��ֵ�Ǹ��ƵĶ����׵�ַ����ԭ����������ͬһ��
		//�ڴ����
		a++;
		arr[0]++; //���ڴ�����[0]Ԫ�ص�ֵ����1
		//System.out.println(a);//6
	}
}





