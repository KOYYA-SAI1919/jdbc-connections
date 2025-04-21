package db_create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class database {
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/";
	private static String username="root";
	private static String password="root";
	private static PreparedStatement pmst;
	private static Connection conn;
	public static void main(String[] args) {
		
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("enter database name: ");
			String sql = "create database "+src.nextLine();
		    pmst=conn.prepareStatement(sql);
			int i=pmst.executeUpdate();
			if(i > 0) {
				System.out.println("database is created");
			}else {
				System.out.println("database is not created");
			}
			pmst.close();
			conn.close();
			src.close();
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
