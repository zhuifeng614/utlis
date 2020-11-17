package demo;

public class Demo07 {

	public static void main(String[] args) {
		int a = 5;//a的值是5
		int[] arr = new int[] {5};
		//引用变量arr变量的值是对象的首地址
		//因为引用变量传递后都引用了同一个对象
		//造成 main方法和test方法共享了同一个对象
		//所以在test方法中修改对象，相当于也影响了main
		//main方法中共享的对象。
		test(a, arr);
		System.out.println(a);//5
		System.out.println(arr[0]);//6
	}
	public static void test(int a, int[] arr) {
		//方法参数传递时候 将原a的值复制了一份给a
		//arr的值是复制的对象首地址，与原变量引用了同一个
		//内存对象
		a++;
		arr[0]++; //将内存对象的[0]元素的值增加1
		//System.out.println(a);//6
	}
}





