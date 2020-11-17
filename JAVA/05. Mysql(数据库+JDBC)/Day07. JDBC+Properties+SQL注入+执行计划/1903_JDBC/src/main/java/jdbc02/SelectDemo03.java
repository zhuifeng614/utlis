package jdbc02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import util.DBUtil;

public class SelectDemo03 {

	public static void main(String[] args) {
		/**
		 * 演示JDBC查询功能
		 */
		String sql="select id, name from t_user";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			Statement st=conn.createStatement();
			//Result结果, Set集, 结果集对象封装了查询结果
			ResultSet rs=st.executeQuery(sql);
			//利用while和next方法配合移动 "结果集游标"
			while(rs.next()) {
				//读取rs当前行中的数据
				int id = rs.getInt("id");
				String name=rs.getString("name");
				System.out.println(id+","+name);
 			}
			rs.close();//可以不关闭rs, conn关闭时候自动关闭rs
			st.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}

}





