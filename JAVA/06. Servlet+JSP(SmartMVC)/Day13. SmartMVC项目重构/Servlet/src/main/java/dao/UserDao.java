package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;
import util.DBUtil;

public class UserDao {
	
	public User findUserByName(String name) {
		String sql="select id, name, password, email "
				+ "from t_user where name=?";
		try(Connection conn = DBUtil.getConnection()){
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			User user=null;
			while(rs.next()) {
				user = row2user(rs);
			}
			return user;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private User row2user(ResultSet rs) 
		throws SQLException{
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String password = rs.getString("password");
		String email = rs.getString("email"); 
		return new User(id, name, password, email); 
	}

}






