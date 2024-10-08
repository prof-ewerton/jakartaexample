package br.mendonca.app.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.mendonca.app.model.entities.User;

public class UserDAO {

	public void saveUser(User user) throws SQLException {
		PostgresConnection pc = PostgresConnection.getInstante();
		Connection conn = pc.getConnection();
		
		try {
			String sql = "INSERT INTO user (email,password,name) VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPass());
			ps.setString(3, user.getName());
			
			ps.execute();
			conn.commit();
		} finally {
			pc.closeConnection(conn);
		}
	}
	
	public User login(String email, String pass) throws SQLException {
		PostgresConnection pc = PostgresConnection.getInstante();
		Connection conn = pc.getConnection();
		
		try {
			String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
			}
			
			ps.execute();
			conn.commit();
		} finally {
			pc.closeConnection(conn);
		}
		
		return null;
	}
}
