package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	private static BasicDataSource ds;
	static {
		ds = new BasicDataSource();
		//读取配置文件, 初始化连接池对象
		Properties cfg = new Properties();
		try {
			InputStream in = DBUtil.class.getClassLoader()
				.getResourceAsStream("db.properties");
			cfg.load(in);
			in.close();
			String driver=cfg.getProperty("driver");
			String url=cfg.getProperty("url");
			String username=cfg.getProperty("username");
			String password=cfg.getProperty("password");
			int initial=Integer.parseInt(
					cfg.getProperty("initial"));
			int max = Integer.parseInt(
					cfg.getProperty("max"));
			int idle = Integer.parseInt(
					cfg.getProperty("idle")); 
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
			ds.setInitialSize(initial);
			ds.setMaxActive(max);
			ds.setMaxIdle(idle);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public static Connection getConnection() 
		throws SQLException {
		return ds.getConnection();
	}
	public static void close(Connection conn) {
		try {
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 关闭掉连接池
	 */
	public static void close() {
		try {
			ds.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}







