package exception;
/**
 * ʹ�õ�ǰ������쳣���׳�
 * @author ta
 *
 */
public class Person {
	private int age;

	public int getAge() {
		return age;
	}
	/**
	 * ��һ��������ʹ��throw�׳�ĳ���쳣ʱ����Ҫ��
	 * �������������ͬʱʹ��throws��������쳣����
	 * ������֪ͨ�����ߴ�������쳣��
	 * ע:
	 * ֻ���׳�RuntimeException�����������쳣ʱ��
	 * ��������ǿ��Ҫ�����ʹ��throws�����������쳣
	 * ���Ǳ���ġ�
	 * @param age
	 * @throws Exception
	 */
	public void setAge(int age)throws IllegalAgeException {
		if(age<0||age>100) {
			throw new IllegalAgeException("���䲻�Ϸ�!");
		}
		this.age = age;
	}
	
	
}
