package exception;
/**
 * 使用当前类测试异常的抛出
 * @author ta
 *
 */
public class Person {
	private int age;

	public int getAge() {
		return age;
	}
	/**
	 * 当一个方法中使用throw抛出某个异常时，就要在
	 * 这个方法声明的同时使用throws声明这个异常的抛
	 * 出，以通知调用者处理这个异常。
	 * 注:
	 * 只有抛出RuntimeException及其子类型异常时，
	 * 编译器不强制要求必须使用throws，其他类型异常
	 * 则是必须的。
	 * @param age
	 * @throws Exception
	 */
	public void setAge(int age)throws IllegalAgeException {
		if(age<0||age>100) {
			throw new IllegalAgeException("年龄不合法!");
		}
		this.age = age;
	}
	
	
}
