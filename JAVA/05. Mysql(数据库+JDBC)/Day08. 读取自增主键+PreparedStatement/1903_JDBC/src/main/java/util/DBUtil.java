package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 抽取封装数据库连接/关闭过程, 用于简化数据库编程 
 */
public class DBUtil {
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password; 
	static {
		try {
			//利用静态代码块初始化静态属性
			String file="db.properties";
			//configuration:配置信息, 缩写为 cfg 
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
	 * 封装数据库连接过程, 返回数据库连接对象
	 * @return 数据库连接对象
	 * @throws Exception 如果数据库驱动无法注册, 则抛出异常
	 *   不能连接到数据库
	 */
	public static Connection getConnection() 
			throws Exception {
		//将数据库驱动程序类名也放到配置文件中
		Class.forName(driverClass);
		Connection conn = DriverManager.getConnection(
				url, username, password);
		return conn;
	}
	/**
	 * 关闭数据库连接方法
	 * @param conn 被关闭的数据库连接
	 */
	public static void close(Connection conn) {
		//如果数据库在关闭期间出现意外, 是无需处理的异常
		//可以直接忽略!
		try {
			//检查conn对象是否为null, 避免空指针异常!
			if(conn!=null) {
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}












