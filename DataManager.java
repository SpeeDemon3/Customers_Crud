package customerDatabaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataManager {
	
	private static Connection conn = null;
	
	public DataManager() {
		
		try {
			conecction();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void conecction() throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/customers/";
		String user = "root";
		String pass = "";
		
		
		conn = DriverManager.getConnection(url + user + pass);
		
		if (conn != null) {
			conn.setReadOnly(false);
			System.out.println("connection with the database...");
		}
	}
	
	private static void closeConnection() throws SQLException {
		conn.close();
	}
	
	protected static void numberOfRecords(String table) throws SQLException {
		
		int count = 0;
		
		ResultSet rs = null;
		Statement stat = conn.createStatement(); 
		
		rs = stat.executeQuery("Select * From " + table + ";");
		while (rs.next()) {
			count++;
		}
		
		
		System.out.println("Number of records: " + count);
		
		closeConnection();
		
	}
	
	protected static void showCustomers(String table) throws SQLException {
				
		ResultSet rs = null;
		Statement stat = conn.createStatement(); 
		
		rs = stat.executeQuery("Select * From " + table + ";");
		while (rs.next()) {
			System.out.println("ID -> " + rs.getInt(1));
			System.out.println("NAME -> " + rs.getString(2));
			System.out.println("ADDRESS -> " + rs.getString(3));
		}
		
		closeConnection();
		
	}
	
	protected static void insertCustomer(String name, String address) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO customers VALUES (?,?)");
		
		ps.setString(2, name);
		
		ps.setString(3, address);
		
		ps.executeUpdate();
		
		closeConnection();
		
	}
	
	protected static void updateCustomer(int id, String name, String address) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("Update customers Set name=?, address=? WHERE id=?");
		
		ps.setString(2, name);
		ps.setString(3, address);
		
		ps.executeUpdate();
		
		closeConnection();
		
	}
	
	protected static void deleteCustomer(int id) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("DELETE FROM customers WHERE id=?");
		
		ps.setInt(1, id);
		
		ps.executeQuery();
		
		closeConnection();
		
	}
	
	protected static void searchCustomer(int id) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM customers WHERE id=?");
		
		ps.setInt(0, id);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			System.out.println("Searching customer....");
			System.out.println("ID -> " + rs.getInt(1));
			System.out.println("NAME -> " + rs.getString(2));
			System.out.println("ADDRESS -> " + rs.getString(3));
		}
		
		closeConnection();
		
	}
	

}
