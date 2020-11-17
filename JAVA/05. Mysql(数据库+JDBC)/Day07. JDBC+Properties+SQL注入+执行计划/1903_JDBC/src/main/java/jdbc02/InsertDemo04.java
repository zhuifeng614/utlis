package jdbc02;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DBUtil;

public class InsertDemo04 {

	public static void main(String[] args) {
		/**
		 * �����в����Ĳ������
		 */
		System.out.println(addUser(10, "Jerry"));
		System.out.println(addUser(11, "�ܴ�"));
		System.out.println(addUser(12, "�ܶ�"));
	}
	public static int addUser(int id, String name) {
		//update t_user set name=? where id=?
		String sql="insert into t_user (id, name) "
				+ "values (?,?)";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			//����SQL��������, ����ִ�мƻ�
			PreparedStatement ps=
					conn.prepareStatement(sql);
			//�滻ִ�мƻ�����
			ps.setInt(1, id);   //�󶨵�һ������
			ps.setString(2, name); //�󶨵ڶ�������
			//ִ�б���õ�ִ�мƻ�
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





