package thread;

import java.util.Scanner;

/**
 * 睡眠阻塞
 * static void sleep(long ms)
 * 该方法可以让执行该方法的线程阻塞指定毫秒
 * 
 * @author ta
 *
 */
public class ThreadDemo7 {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		/*
		 * 实现一个倒计时程序
		 * 要求用户在控制台输入一个数字，然后每秒
		 * 递减，到0的时候提示"时间到"
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入数字:");
		int num = Integer.parseInt(scanner.nextLine());
		for(;num>0;num--) {
			System.out.println(num);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("时间到!");
		System.out.println("程序结束了");
	}
}







