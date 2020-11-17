package day12;


public class TestCase {
	
	public void t() {
		System.out.println("t");
	}
	
	@Test //自定义注解
	public void testHello() {
		System.out.println("Hello World!");
	}

	@Test
	public void demo() {
		System.out.println("demo!");
	}

}
