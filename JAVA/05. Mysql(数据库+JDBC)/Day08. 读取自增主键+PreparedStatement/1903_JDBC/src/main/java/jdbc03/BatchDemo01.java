package jdbc03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;

import javax.crypto.AEADBadTagException;

import util.DBUtil;

public class BatchDemo01 {

	public static void main(String[] args) {
		/**
		 * �������������ݵ����ݿ�ִ��
		 */
		String sql=
			"insert into t_user (id, name) values (?,?)";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, 100);
			ps.setString(2, "user1");
			//������������ӵ�ps�Ĳ�����������
			ps.addBatch();
			
			ps.setInt(1, 101);
			ps.setString(2, "user2");
			//������������ӵ�ps�Ĳ�����������
			ps.addBatch();
			
			//���������еĲ���һ�����͵�������ִ��
			int[] arr = ps.executeBatch();
			System.out.println(Arrays.toString(arr)); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

}
