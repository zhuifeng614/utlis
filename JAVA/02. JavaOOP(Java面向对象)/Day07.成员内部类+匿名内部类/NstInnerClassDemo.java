package oo.day07;
//�����ڲ������ʾ
public class NstInnerClassDemo {
	public static void main(String[] args) {
		//1)������Coo��һ�������࣬����û������
		//2)Ϊ�������ഴ����һ��������Ϊo1
		//3)�������е�Ϊ�����������
		Coo o1 = new Coo() {
			
		};
		
		//1)������Coo��һ�������࣬����û������
		//2)Ϊ�������ഴ����һ��������Ϊo2
		//3)�������е�Ϊ�����������
		Coo o2 = new Coo() {
			
		};
		
		int num = 5;
		//1)������Doo��һ�������࣬����û������
		//2)Ϊ�������ഴ����һ��������Ϊo3
		//3)�������е�Ϊ�����������
		Doo o3 = new Doo() {
			void show() {
				System.out.println("showshow");
				System.out.println(num);
			}
		};
		o3.show();
		
	}
}

abstract class Doo{
	abstract void show();
}

abstract class Coo{
}




















