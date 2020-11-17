package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo03 {

	public static void main(String[] args) 
		throws Exception {
		/**
		 * 利用JDBC执行插入语句
		 */
		String sql="insert into t_user "
				+ "(id, name) "
				+ "values (2, '范传奇')"; 
		//注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//连接数据库
		String url="jdbc:mysql://localhost:3306/db6?characterEncoding=utf8&useUnicode=true&useSSL=false";
		String username="root";
		String password="root";
		Connection conn = DriverManager.getConnection(
			url, username, password);
		//创建 Statement对象
		Statement st = conn.createStatement();
		//executeUpdate 返回数据库中更新行数!
		int n = st.executeUpdate(sql);
		//处理SQL结果
		if(n==1) {
			System.out.println("插入成功!");
		}
		//关闭资源和连接
		st.close();
		conn.close();
	}

}






