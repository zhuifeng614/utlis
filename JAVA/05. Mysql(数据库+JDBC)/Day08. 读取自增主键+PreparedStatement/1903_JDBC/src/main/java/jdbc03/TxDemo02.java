package jdbc03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class TxDemo02 {

	public static void main(String[] args) {
		/**
		 * ������ʾ
		 */
		trans(1, 2, 2000); 
		trans(3, 2, 500); 
		trans(1, 3, 500);
		trans(1, 2, 500);
	}
	/**
	 * �� from �˺� �� to �˺�תǮ, Ǯ����money
	 */
	public static void trans(
			int from, int to, double money) {
		String sql1="update acc set balance=balance+? "
				+ "where id=?";
		String sql2="select balance from acc where id=?";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false); 
			PreparedStatement ps=conn.prepareStatement(sql1);
			ps.setDouble(1, -money); //-500
			ps.setInt(2, from);
			int n = ps.executeUpdate();
			if(n!=1) throw new Exception("���ʧ��"); 
			ps.setDouble(1, money); //500
			ps.setInt(2, to); 
			n = ps.executeUpdate();
			if(n!=1) throw new Exception("����ʧ��"); 
			ps.close();//ps����������, �ر��ͷ�
			//������˵����
			ps = conn.prepareStatement(sql2); //����ps����
			ps.setInt(1, from); 
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				double balance = rs.getDouble("balance");
				if(balance<0) throw new Exception("͸֧");
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if(conn!=null) {
					conn.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBUtil.close(conn); 
		}
	}

}




