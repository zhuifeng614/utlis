package jdbc02;

import java.sql.Connection;
import java.sql.Statement;

import util.DBUtil;

public class BatchSQLDemo09 {

	public static void main(String[] args) {
		/**
		 * ����ִ��SQL
		 */
		String[] sql = {
			"create table t_1(id int, name varchar(50))",
			"create table t_2(id int, name varchar(50))",
			"create table t_3(id int, name varchar(50))",
			"create table t_4(id int, name varchar(50))",
			"create table t_5(id int, name varchar(50))",
			"create table t_6(id int, name varchar(50))",
			"create table t_7(id int, name varchar(50))",
			"create table t_8(id int, name varchar(50))",
			"insert into t_1(id, name) values (1,'Tom')"
		};
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			
			//Batch ���� 
			//addBatch ��SQL��ӵ� st �Ļ�����
			st.addBatch(sql[0]);
			st.addBatch(sql[1]);
			st.addBatch(sql[2]);
			st.addBatch(sql[3]);
			st.addBatch(sql[4]);
			st.addBatch(sql[5]);
			st.addBatch(sql[6]);
			st.addBatch(sql[7]);
			st.addBatch(sql[8]);
			//executeBatch��һ��SQLһ���͵����ݿ�ִ��
			int[] arr = st.executeBatch();
			for (int i : arr) {
				System.out.println(i); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		
	}

}








