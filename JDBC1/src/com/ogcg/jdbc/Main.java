package com.ogcg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tableName = "Producto";
		Connection connection = ConnManager.getConnection();
		if(connection != null) {			
			
			
			Statement stmt = null;
		    String query = "SELECT *" +
		                   "from " + tableName;
		    try {
		        stmt = connection.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		        	Integer id = rs.getInt("id");
		            String description = rs.getString("description");
		            System.out.println(id + ": " + description);
		        }
		    } catch (SQLException e ) {
		        System.out.println(e);
		    } finally {
		        if (stmt != null) { try {
		        	System.out.println("Closing statement");
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} }
		    }
		    
		    
			try {
				System.out.println("Closing down");
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println(":D");
		}
	}
}
