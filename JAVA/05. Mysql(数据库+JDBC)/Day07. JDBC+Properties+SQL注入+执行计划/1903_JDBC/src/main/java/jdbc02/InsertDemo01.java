package jdbc02;

import java.sql.Connection;
import java.sql.Statement;

import util.DBUtil;

public class InsertDemo01 {

	public static void main(String[] args) {
		/**
		 * 向数据库插入数据
		 */
		String sql="insert into t_user values (9,'Nemo')";
		Connection conn=null;
		try {
			//利用数据库连接工具连接到数据库
			conn=DBUtil.getConnection();
			//创建Statement对象
			Statement st = conn.createStatement();
			//执行SQL
			int n = st.executeUpdate(sql);
			//处理结果
			System.out.println(n);
			st.close();
			//st对象可以不关闭, conn关闭时候会自动关闭st对象
		}catch(Exception e) {
			e.printStackTrace(); 
		}finally {
			//可靠关闭数据库的连接!!!
			DBUtil.close(conn); 
		}
	}
}




