package jdbc02;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DBUtil;

public class UpdateDemo05 {

	public static void main(String[] args) {
		/**
		 * 更新数据
		 */
		System.out.println(updateUser(10, "王克晶"));
		System.out.println(updateUser(11, "威震天"));
	}
	public static int updateUser(int id, String name) {
		String sql="update t_user set name=? "
				+ "where id=? ";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps=
					conn.prepareStatement(sql);
			ps.setInt(2, id);   //绑定第一个参数
			ps.setString(1, name); //绑定第二个参数
			int n = ps.executeUpdate(); //不要传递SQL参数!!!
			return n;
		} catch (Exception e) {
			e.printStackTrace();
			return 0; //返回0表示插入失败
		}finally {
			DBUtil.close(conn);
		}

	}

}
