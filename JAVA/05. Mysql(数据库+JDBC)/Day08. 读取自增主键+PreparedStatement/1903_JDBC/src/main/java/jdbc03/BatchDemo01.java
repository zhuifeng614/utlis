package jdbc03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;

import javax.crypto.AEADBadTagException;

import util.DBUtil;

public class BatchDemo01 {

	public static void main(String[] args) {
		/**
		 * 将批量参数传递到数据库执行
		 */
		String sql=
			"insert into t_user (id, name) values (?,?)";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, 100);
			ps.setString(2, "user1");
			//将上述参数添加到ps的参数缓冲区中
			ps.addBatch();
			
			ps.setInt(1, 101);
			ps.setString(2, "user2");
			//将上述参数添加到ps的参数缓冲区中
			ps.addBatch();
			
			//将缓冲区中的参数一批发送到服务器执行
			int[] arr = ps.executeBatch();
			System.out.println(Arrays.toString(arr)); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

}
