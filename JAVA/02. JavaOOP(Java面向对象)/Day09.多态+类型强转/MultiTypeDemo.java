package oo.day09;
//��̬����ʾ
public class MultiTypeDemo {
	public static void main(String[] args) {
		Aoo o = new Boo(); //��������
		Boo o1 = (Boo)o; //oָ��Ķ������Boo������
		Inter1 o2 = (Inter1)o; //oָ��Ķ���ʵ����Inter1�ӿ�
		//Coo o3 = (Coo)o; //ClassCastException����ת���쳣
		if(o instanceof Coo) { //false
			Coo o4 = (Coo)o;
		}else {
			System.out.println("o����Coo����");
		}
	}
}

interface Inter1{
}
class Aoo{
}
class Boo extends Aoo implements Inter1{
}
class Coo extends Aoo{
}
























