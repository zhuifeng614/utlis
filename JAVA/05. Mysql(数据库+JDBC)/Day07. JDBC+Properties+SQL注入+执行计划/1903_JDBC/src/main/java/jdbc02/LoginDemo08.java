package jdbc02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import util.DBUtil;

public class LoginDemo08 {

	public static void main(String[] args) {	
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.print("�����û�:");
			String name = in.nextLine();
			System.out.print("��������:");
			String password = in.nextLine();
			if(login(name, password)) {
				System.out.println("��¼�ɹ�!");
				break;
			}
		}
	}
	public static boolean login(String name, 
			String password) {
		String sql = "select count(*) as c from "
				+ "users where name=? and password=?";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int c = rs.getInt("c");
				return c == 1;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			DBUtil.close(conn);
		}
	}
}
