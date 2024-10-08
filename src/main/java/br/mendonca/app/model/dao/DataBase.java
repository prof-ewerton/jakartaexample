package br.mendonca.app.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	
	public void deleteTableUser() throws SQLException {
		PostgresConnection pc = PostgresConnection.getInstante();
		Connection conn = pc.getConnection();
		conn.setAutoCommit(false);
		
		try {
			String sql = "DROP TABLE IF EXISTS users";
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
			st.close();
			
			conn.commit();
		} finally {
			conn.close();
			pc.closeConnection(conn);
		}
	}
	
	public void createTableUser() throws SQLException {
		this.deleteTableUser();
		
		PostgresConnection pc = PostgresConnection.getInstante();
		Connection conn = pc.getConnection();
		conn.setAutoCommit(false);
		
		try {
			String sql = "CREATE TABLE users ("
					+ "    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,"
					+ "    name VARCHAR(255) NOT NULL,"
					+ "    email VARCHAR(255) NOT NULL,"
					+ "    password VARCHAR(255) NOT NULL)";
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
			st.close();
			
			conn.commit();
		} finally {
			pc.closeConnection(conn);
		}
	}
}
