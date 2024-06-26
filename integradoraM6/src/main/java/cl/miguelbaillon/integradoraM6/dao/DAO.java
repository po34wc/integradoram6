package cl.miguelbaillon.integradoraM6.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	private Connection conn;
	private ResultSet resultSet;
	private Statement stmt;
	
	protected void conectarDb() {
		System.out.println("Conectado a la Base de Datos");
		try {
			if(conn == null || conn.isClosed()) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String stringConection = "jdbc:mysql://localhost:3306/integradoram6";
				String user = "root";
				String pass = "hola#adios";
				conn = DriverManager.getConnection(stringConection,user,pass);
			}
		} catch(ClassNotFoundException ex) {
			System.out.println("Error:Driver no encontrado");
		} catch(SQLException ex) {
			System.out.println("Fallo.");
			System.out.println("SQLException:" + ex.getMessage());
			System.out.println("SQLState:" + ex.getSQLState());
			System.out.println("VendorError:" + ex.getErrorCode());
		}
	}
	
	protected ResultSet consultar(String sql) {
		try {
			conectarDb();
			this.stmt = conn.createStatement();
			resultSet = stmt.executeQuery(sql);
			//close();
			return resultSet;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
	}
	
	protected int ejecutarSql(String sql) {
		try {
			conectarDb();
			this.stmt = conn.createStatement();
			int regModificados = stmt.executeUpdate(sql);
			
			//close();
			return regModificados;
			
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return 0;
		}
	}	
}
