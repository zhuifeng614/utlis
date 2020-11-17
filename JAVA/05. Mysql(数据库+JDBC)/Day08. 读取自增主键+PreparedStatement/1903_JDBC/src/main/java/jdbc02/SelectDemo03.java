package jdbc02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import util.DBUtil;

public class SelectDemo03 {

	public static void main(String[] args) {
		/**
		 * ��ʾJDBC��ѯ����
		 */
		String sql="select id, name from t_user";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			Statement st=conn.createStatement();
			//Result���, Set��, ����������װ�˲�ѯ���
			ResultSet rs=st.executeQuery(sql);
			//����while��next��������ƶ� "������α�"
			while(rs.next()) {
				//��ȡrs��ǰ���е�����
				int id = rs.getInt("id");
				String name=rs.getString("name");
				System.out.println(id+","+name);
 			}
			rs.close();//���Բ��ر�rs, conn�ر�ʱ���Զ��ر�rs
			st.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}

}





