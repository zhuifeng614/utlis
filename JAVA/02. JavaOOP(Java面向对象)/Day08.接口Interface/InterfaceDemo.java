package oo.day08;
//�ӿڵ���ʾ
public class InterfaceDemo {
	public static void main(String[] args) {
		//Inter6 o1 = new Inter6(); //������󣬽ӿڲ��ܱ�ʵ����
		Inter6 o2 = new Doo(); //��������
		Inter5 o3 = new Doo(); //��������
		/*
		 * �ӿڵ���ϰ:  interface  implements
		 * 1.�����ӿ�Inter1����������PI�ͳ��󷽷�test()
		 * 2.�����ӿ�Inter2������a()��b()
		 *     ������Aoo��ʵ��Inter2
		 * 3.�����ӿ�Inter3������c()
		 *     ������Boo��ʵ��Inter2��Inter3
		 * 4.����������Coo���������󷽷�d()
		 *     ������Doo���̳�Coo��ʵ��Inter2��Inter3
		 * 5.�����ӿ�Inter4���̳�Inter3������e()
		 *     ������Eoo��ʵ��Inter4
		 * 6.��main��:
		 *   1)Inter4 o1 = new Inter4();-----------???
		 *   2)Inter4 o2 = new Eoo();--------------???
		 *   3)Inter3 o3 = new Eoo();--------------???
		 */
	}
}















//��ʾ�ӿڼ̳нӿ�
interface Inter5{
	void show();
}
interface Inter6 extends Inter5{
	void test();
}
class Doo implements Inter6{
	public void test() {}
	public void show() {}
}







//��ʾ�ӿڵĶ�ʵ�֣��ȼ̳к�ʵ��
interface Inter3{
	void show();
}
interface Inter4{
	void test();
}
abstract class Boo{
	abstract void say();
}
class Coo extends Boo implements Inter3,Inter4{
	public void show() {}
	public void test() {}
	void say() {}
}






//��ʾ�ӿڵ�ʵ��
interface Inter2{
	void show();
	void test();
}
class Aoo implements Inter2{
	public void show() {}
	public void test() {}
}



//��ʾ�ӿڵ��﷨
interface Inter1{
	public static final int NUM = 5;
	public abstract void show();
	int COUNT = 5; //Ĭ��public static final
	void test();   //Ĭ��public abstract
	
	//int number; //������󣬳�����������ͬʱ��ʼ��
	//void say() {} //������󣬳��󷽷������з�����
}












































