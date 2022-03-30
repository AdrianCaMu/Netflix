package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import utils.Credentials;

public class AbstractDAO {
	private final String DB_URL = Credentials.getUrlDB();
	private final String USER = Credentials.getUserDB();
	private final String PASS = Credentials.getPassDB();
	protected Connection conn;
	protected Statement stmt;
	
	public AbstractDAO(){
		try {
			this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
			this.stmt = conn.createStatement();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}