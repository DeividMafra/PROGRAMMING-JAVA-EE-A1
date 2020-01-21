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
	
	public void updateCartoon() throws ClassNotFoundException, SQLException {
		try {
		      
			String sql = "update cartoons set Name = ?, Description = ?, PG = ? where idCartoons = ?";
		       
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Please enter the cartoon Id!");
			int id = sc.nextInt();
			sc.nextLine(); // to consume the space
			
			System.out.println("Please enter the cartoon's name of id: "+id);
			String name = sc.nextLine();
						
			System.out.println("Please enter the cartoon's description of id: "+id);
			String desc = sc.nextLine();
			
			
			System.out.println("Please enter the cartoon's Parental Guidance of id: "+id);
			int pG = sc.nextInt();
			sc.nextLine(); // to consume the space

		  	Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
		      
			
			pstmt.setString(1,name);
			pstmt.setString(2,desc);
			pstmt.setInt(3, pG);
			pstmt.setInt(4, id);

			pstmt.executeUpdate();
			diplayCartoons();
		      
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
		}
	
	public void deleteCartoon() throws ClassNotFoundException, SQLException {
		try {
		      
			String sql = "delete from cartoons where idCartoons = ?";
		       
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Please enter Id to be deleted");
			int id = sc.nextInt();

		  	Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
		      
			pstmt.setInt(1, id);

			pstmt.executeUpdate();
			
			System.out.println("Cartoon of id: "+id+ " deleted!");
			  
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
		}

}
