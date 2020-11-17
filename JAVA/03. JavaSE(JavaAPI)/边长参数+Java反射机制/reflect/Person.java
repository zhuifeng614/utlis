package reflect;

public class Person {
	
	private String name;
	private int age;	
	public Person() {
		
	}
	public Person(String name) {
		this.name = name;
	}
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	public void sayHello() {
		System.out.println("person:hello!");
	}
	
	public void sayHi() {
		System.out.println("person:hi!");
	}
	
	public void say(String name) {
		System.out.println("大家好！我是"+name);
	}
	
	public String toString() {
		return "Person["+name+","+age+"]";
	}
}



