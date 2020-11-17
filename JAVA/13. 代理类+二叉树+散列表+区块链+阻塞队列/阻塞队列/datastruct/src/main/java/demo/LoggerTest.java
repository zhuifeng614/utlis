package demo;

public class LoggerTest {

	public static void main(String[] args) {
		Logger logger = new Logger();
		/*
		 * 启动消费者线程,该线程会不停地从
		 * 阻塞队列中取日志信息，然后将日志
		 * 信息写入到文件。
		 * 如果队列为空，则该线程处理阻塞状态。
		 */
		logger.open();
		/*
		 * 记日志:
		 *  即将日志信息添加到阻塞队列里面。
		 */
		logger.println("hello Kitty");
		logger.println("hello Jerry");
		logger.println("hello Tom");
		
		try {
			/*
			 * 模型应用程序执行了一段时间，给消费者
			 * 线程一些时间来完成从阻塞队列
			 * 中取日志，并写入文件。
			 */
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.close();
	}

}
