package db_create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class db_insertion {
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/database1";
	private static final String username="root";
	private static final String password="root";
	private static Connection conn;
	private static PreparedStatement pmst;
	
	
public static void main(String[] args) {
	try {
		Scanner sc =new Scanner(System.in);
		Class.forName(driver);
		conn = DriverManager.getConnection(url,username,password);
		String sql="insert into table1(id,name,email) values(?,?,?)";
	    pmst=conn.prepareStatement(sql);
	    System.out.println("enter login id");
	    pmst.setString(1,sc.nextLine());
	    System.out.println("enter login name");
	    pmst.setString(2,sc.nextLine());
	    System.out.println("enter login email");
	    pmst.setString(3,sc.nextLine());
	    int i=pmst.executeUpdate();
	    if(i>0) {
	    	System.out.println("data inserted");
	    }else {
	    	System.out.println("data not inserted");
	    	
	    }
	    pmst.close();
		conn.close();
		sc.close();
	    
	    
	    
	    
		
	}catch (Exception e) {
		e.printStackTrace();
	
}

}}
