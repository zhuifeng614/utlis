package oo.day07;
//��Ա�ڲ������ʾ
public class InnerClassDemo {
	public static void main(String[] args) {
		Mama m = new Mama();
		//Baby b = new Baby(); //��������ڲ�����ⲻ�߱��ɼ���
	}
}

class Mama{
	private String name;
	void createBaby() {
		Baby b = new Baby(); //��ȷ
	}
	class Baby{
		void showMamaName() {
			System.out.println(name);
			System.out.println(Mama.this.name);
			//System.out.println(this.name); //�������
		}
	}
}





























