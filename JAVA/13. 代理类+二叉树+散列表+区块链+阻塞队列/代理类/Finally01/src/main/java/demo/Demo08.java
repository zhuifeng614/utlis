package demo;

public class Demo08 {

	public static void main(String[] args) {
		/**
		 * 
		 */
		String s = "A";
		StringBuilder ss = new StringBuilder("A");
		test(s, ss);
		System.out.println(s+","+ss); //A,AA
	}
	
	public static void test(
			String s, StringBuilder ss) {
		//s ss
		s+="A";
		ss.append("A");
	}

}
