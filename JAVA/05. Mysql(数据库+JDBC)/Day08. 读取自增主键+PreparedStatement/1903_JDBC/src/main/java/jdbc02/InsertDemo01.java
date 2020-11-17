package jdbc02;

import java.sql.Connection;
import java.sql.Statement;

import util.DBUtil;

public class InsertDemo01 {

	public static void main(String[] args) {
		/**
		 * �����ݿ��������
		 */
		String sql="insert into t_user values (9,'Nemo')";
		Connection conn=null;
		try {
			//�������ݿ����ӹ������ӵ����ݿ�
			conn=DBUtil.getConnection();
			//����Statement����
			Statement st = conn.createStatement();
			//ִ��SQL
			int n = st.executeUpdate(sql);
			//������
			System.out.println(n);
			st.close();
			//st������Բ��ر�, conn�ر�ʱ����Զ��ر�st����
		}catch(Exception e) {
			e.printStackTrace(); 
		}finally {
			//�ɿ��ر����ݿ������!!!
			DBUtil.close(conn); 
		}
	}
}




