package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo03 {

	public static void main(String[] args) 
		throws Exception {
		/**
		 * ����JDBCִ�в������
		 */
		String sql="insert into t_user "
				+ "(id, name) "
				+ "values (2, '������')"; 
		//ע������
		Class.forName("com.mysql.jdbc.Driver");
		
		//�������ݿ�
		String url="jdbc:mysql://localhost:3306/db6?characterEncoding=utf8&useUnicode=true&useSSL=false";
		String username="root";
		String password="root";
		Connection conn = DriverManager.getConnection(
			url, username, password);
		//���� Statement����
		Statement st = conn.createStatement();
		//executeUpdate �������ݿ��и�������!
		int n = st.executeUpdate(sql);
		//����SQL���
		if(n==1) {
			System.out.println("����ɹ�!");
		}
		//�ر���Դ������
		st.close();
		conn.close();
	}

}






