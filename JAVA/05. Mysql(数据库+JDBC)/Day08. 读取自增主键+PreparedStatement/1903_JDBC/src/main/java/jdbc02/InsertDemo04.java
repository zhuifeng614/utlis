package jdbc02;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DBUtil;

public class InsertDemo04 {

	public static void main(String[] args) {
		/**
		 * 测试有参数的插入语句
		 */
		System.out.println(addUser(10, "Jerry"));
		System.out.println(addUser(11, "熊大"));
		System.out.println(addUser(12, "熊二"));
	}
	public static int addUser(int id, String name) {
		//update t_user set name=? where id=?
		String sql="insert into t_user (id, name) "
				+ "values (?,?)";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			//发送SQL到服务器, 编译执行计划
			PreparedStatement ps=
					conn.prepareStatement(sql);
			//替换执行计划参数
			ps.setInt(1, id);   //绑定第一个参数
			ps.setString(2, name); //绑定第二个参数
			//执行编译好的执行计划
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





