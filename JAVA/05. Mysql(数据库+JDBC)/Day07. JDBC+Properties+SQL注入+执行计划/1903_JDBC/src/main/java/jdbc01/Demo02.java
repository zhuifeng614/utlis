package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo02 {

	public static void main(String[] args) 
		throws Exception {
		/**
		 * 利用JDBC执行删除语句
		 */
		String sql="delete from t_user where id=1";  
		//注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//连接数据库
		String url="jdbc:mysql://localhost:3306/db6";
		String username="root";
		String password="root";
		Connection conn = DriverManager.getConnection(
			url, username, password);
		//创建 Statement对象
		Statement st = conn.createStatement();
		//executeUpdate 返回数据库中更新行数!
		int n = st.executeUpdate(sql);
		//处理SQL结果
		if(n>=1) {
			System.out.println("删除成功!");
		}else {
			System.out.println("删除失败!");
		}
		//关闭资源和连接
		st.close();
		conn.close();
	}

}






