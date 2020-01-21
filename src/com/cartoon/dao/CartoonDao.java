package com.cartoon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CartoonDao {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/assignment1";
		String user = "root";
		String pwd  ="";
		
		Connection conn = DriverManager.getConnection(url,user,pwd);
		System.out.println("Connection Successfull:");
//		System.out.println("ID"+"  "+"Name"+"    "+"Age"+"    "+"Course"+"     "+"Contact");
		return conn;
		
	}
	
	public void diplayCartoons() throws ClassNotFoundException, SQLException {
		System.out.println("test>>>>>>>>>>");
		String sql = "SELECT * FROM cartoons";
		
		Connection con = getConnection();
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"    "+rs.getString(3)+"     "+rs.getInt(4));
		}	
	}
	
	public void insertCartoon() throws ClassNotFoundException, SQLException {
		
		String sql ="INSERT INTO cartoons (idCartoons,Name,Description,PG) VALUES(?,?,?,?)";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter Cartoon Id!");
		int id = sc.nextInt();
		sc.nextLine(); // to consume the space

		System.out.println("Please enter Cartoon Name!");
		String name = sc.nextLine();
		
		System.out.println("Please enter Cartoon description!");
		String desc = sc.nextLine();
		
		System.out.println("Please enter Cartoon Parental Guidance!");
		int PG = sc.nextInt();
		sc.nextLine(); // to consume the space
				
		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setInt(1,id);
		pstmt.setString(2,name);
		pstmt.setString(3, desc);
		pstmt.setInt(4, PG);
		
		int status = pstmt.executeUpdate();
		
		if(status>0) {
			System.out.println("Record Inserted successfully!!");
			diplayCartoons();
		}
		else {	
			System.out.println("Sorry Try again to insert Record!");
			diplayCartoons();
		}
	}
	
	
	

}
