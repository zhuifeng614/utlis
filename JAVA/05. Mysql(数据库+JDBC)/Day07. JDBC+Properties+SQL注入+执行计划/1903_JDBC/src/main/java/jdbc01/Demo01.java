package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo01 {

	public static void main(String[] args) 
		throws Exception{
		//注册数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
		//建立连接
		String usr="root";
		String pwd="root";
		String url="jdbc:mysql://localhost:3306/db6";
		Connection conn = 
				DriverManager.getConnection(url,usr,pwd);
		//测试:
		System.out.println(conn);  
		//创建Statement对象,执行SQL
		Statement st = conn.createStatement();
		String sql = "create table t_user ("
				+ "id int, "
				+ "name varchar(100))";
		//执行sql语句
		st.execute(sql);
		st.close();
		//关闭连接
		conn.close();
	}

}






