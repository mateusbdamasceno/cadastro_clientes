package br.com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	//Exemplo de criação de uma conexão com o banco. Nesse desafio não foi criado um  banco de fato.
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cliente";
	
	public static Connection createConnectonDb() throws Exception{
		Class.forName("com.jdbc.driver");
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}

}
