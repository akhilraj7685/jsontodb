package com.ak.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnectionService {

	private static String url="jdbc:mysql://localhost:3306/projectsdb";
	private static final String username = "root";
	private static final String password = "root";
	private Connection con=null;
	
	public Connection getDbConnection()throws Exception {
		if(con!=null && !con.isClosed())
			return con;
		
		try {
			Class.forName(
					"com.mysql.cj.jdbc.Driver"); // Driver name
			con = DriverManager.getConnection(
					url, username, password);
			System.out.println(
					"db connection established...");
		}catch (Exception e) {
			e.printStackTrace();
          throw new Exception("Error creating Database connection");
		}
		return con;
	}
	
	
	
}
