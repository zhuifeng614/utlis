package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo01 {

	public static void main(String[] args) 
		throws Exception{
		//ע�����ݿ�����
		Class.forName("com.mysql.jdbc.Driver");
		//��������
		String usr="root";
		String pwd="root";
		String url="jdbc:mysql://localhost:3306/db6";
		Connection conn = 
				DriverManager.getConnection(url,usr,pwd);
		//����:
		System.out.println(conn);  
		//����Statement����,ִ��SQL
		Statement st = conn.createStatement();
		String sql = "create table t_user ("
				+ "id int, "
				+ "name varchar(100))";
		//ִ��sql���
		st.execute(sql);
		st.close();
		//�ر�����
		conn.close();
	}

}






