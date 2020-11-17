package jdbc02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import util.DBUtil;

public class LoginDemo07 {

	public static void main(String[] args) {	
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.print("输入用户:");
			String name = in.nextLine();
			System.out.print("输入密码:");
			String password = in.nextLine();
			if(login(name, password)) {
				System.out.println("登录成功!");
				break;
			}
		}
	}
	public static boolean login(String name, 
			String password) {
		String sql = "select count(*) as c from "
				+ "users where name='"+name+"' "
				+ "and password='"+password+"'";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
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
