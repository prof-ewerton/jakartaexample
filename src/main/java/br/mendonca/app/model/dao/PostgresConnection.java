package br.mendonca.app.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {

	private String user = "postgres";
	private String pass = "postgres";
	private String host = "postgres";
	private String port = "5432";
	private String db = "example";
	
	private static PostgresConnection instante = null;
	
	private PostgresConnection() { }
	
	public static PostgresConnection getInstante() {
		if (instante == null) {
			instante = new PostgresConnection();
		}
		return instante;
	}

	public Connection getConnection() throws SQLException {
		try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver PostgreSQL não encontrado!", e);
        }
        return DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db, user, pass);
	}
	
	public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
