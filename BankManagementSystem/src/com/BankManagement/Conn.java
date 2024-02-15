package com.BankManagement;

import java.sql.*;

public class Conn {
	
	Connection c;
	Statement s;
	public Conn()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","QAZwsxEDC123");
			s = c.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		
}
	
	
	
		
		
	


