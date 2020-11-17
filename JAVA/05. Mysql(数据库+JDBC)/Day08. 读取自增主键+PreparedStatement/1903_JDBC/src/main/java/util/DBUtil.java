package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ��ȡ��װ���ݿ�����/�رչ���, ���ڼ����ݿ��� 
 */
public class DBUtil {
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password; 
	static {
		try {
			//���þ�̬������ʼ����̬����
			String file="db.properties";
			//configuration:������Ϣ, ��дΪ cfg 
			Properties cfg=new Properties();
			InputStream in =DBUtil.class.getClassLoader()
					.getResourceAsStream(file);
			cfg.load(in);
			in.close();
			driverClass = cfg.getProperty("driverClass");
			url = cfg.getProperty("url");
			username = cfg.getProperty("username");
			password = cfg.getProperty("password");
		}catch(IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e); 
		}
	}
	
	/**
	 * ��װ���ݿ����ӹ���, �������ݿ����Ӷ���
	 * @return ���ݿ����Ӷ���
	 * @throws Exception ������ݿ������޷�ע��, ���׳��쳣
	 *   �������ӵ����ݿ�
	 */
	public static Connection getConnection() 
			throws Exception {
		//�����ݿ�������������Ҳ�ŵ������ļ���
		Class.forName(driverClass);
		Connection conn = DriverManager.getConnection(
				url, username, password);
		return conn;
	}
	/**
	 * �ر����ݿ����ӷ���
	 * @param conn ���رյ����ݿ�����
	 */
	public static void close(Connection conn) {
		//������ݿ��ڹر��ڼ��������, �����账����쳣
		//����ֱ�Ӻ���!
		try {
			//���conn�����Ƿ�Ϊnull, �����ָ���쳣!
			if(conn!=null) {
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}












