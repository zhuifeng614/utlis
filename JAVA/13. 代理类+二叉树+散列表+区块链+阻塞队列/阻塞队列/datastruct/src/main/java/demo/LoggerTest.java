package demo;

public class LoggerTest {

	public static void main(String[] args) {
		Logger logger = new Logger();
		/*
		 * �����������߳�,���̻߳᲻ͣ�ش�
		 * ����������ȡ��־��Ϣ��Ȼ����־
		 * ��Ϣд�뵽�ļ���
		 * �������Ϊ�գ�����̴߳�������״̬��
		 */
		logger.open();
		/*
		 * ����־:
		 *  ������־��Ϣ��ӵ������������档
		 */
		logger.println("hello Kitty");
		logger.println("hello Jerry");
		logger.println("hello Tom");
		
		try {
			/*
			 * ģ��Ӧ�ó���ִ����һ��ʱ�䣬��������
			 * �߳�һЩʱ������ɴ���������
			 * ��ȡ��־����д���ļ���
			 */
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.close();
	}

}
