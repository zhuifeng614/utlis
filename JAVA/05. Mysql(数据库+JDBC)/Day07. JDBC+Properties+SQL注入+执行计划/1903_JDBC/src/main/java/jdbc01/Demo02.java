package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo02 {

	public static void main(String[] args) 
		throws Exception {
		/**
		 * ����JDBCִ��ɾ�����
		 */
		String sql="delete from t_user where id=1";  
		//ע������
		Class.forName("com.mysql.jdbc.Driver");
		//�������ݿ�
		String url="jdbc:mysql://localhost:3306/db6";
		String username="root";
		String password="root";
		Connection conn = DriverManager.getConnection(
			url, username, password);
		//���� Statement����
		Statement st = conn.createStatement();
		//executeUpdate �������ݿ��и�������!
		int n = st.executeUpdate(sql);
		//����SQL���
		if(n>=1) {
			System.out.println("ɾ���ɹ�!");
		}else {
			System.out.println("ɾ��ʧ��!");
		}
		//�ر���Դ������
		st.close();
		conn.close();
	}

}






