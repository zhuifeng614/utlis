package jdbc02;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DBUtil;

public class UpdateDemo05 {

	public static void main(String[] args) {
		/**
		 * ��������
		 */
		System.out.println(updateUser(10, "���˾�"));
		System.out.println(updateUser(11, "������"));
	}
	public static int updateUser(int id, String name) {
		String sql="update t_user set name=? "
				+ "where id=? ";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps=
					conn.prepareStatement(sql);
			ps.setInt(2, id);   //�󶨵�һ������
			ps.setString(1, name); //�󶨵ڶ�������
			int n = ps.executeUpdate(); //��Ҫ����SQL����!!!
			return n;
		} catch (Exception e) {
			e.printStackTrace();
			return 0; //����0��ʾ����ʧ��
		}finally {
			DBUtil.close(conn);
		}

	}

}
