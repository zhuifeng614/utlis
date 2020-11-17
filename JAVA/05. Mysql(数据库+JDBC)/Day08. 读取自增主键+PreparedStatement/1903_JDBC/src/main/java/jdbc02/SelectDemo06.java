package jdbc02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;

public class SelectDemo06 {

	public static void main(String[] args) {
		/**
		 * 执行带参数是SQL查询
		 */
		findUser(10);
		findUser(11);
	}
	
	public static void findUser(int id) {
		String sql="select id, name from t_user "
				+ "where id=?"; 
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int uid = rs.getInt("id");
				String name = rs.getString("name");
				System.out.println(uid+","+name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		
	}

}






