package db_create;

import java.util.Scanner;



import java.sql.*;

public class dynamic {
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static String username="root";
	private static String password="root";
	private static PreparedStatement pmst;
	private static Connection conn;
	
	
	public static void main(String[] args) {
		int choice;
		do {
			Scanner src=new Scanner(System.in);
			System.out.println("choose your choice");
			DisplayMenu();
			choice=Integer.parseInt(src.next());
			switch(choice) {
			case 1:
				CreateDatabse();
				break;
			case 2:
				DropDatabse();
				break;
			case 3:
				DataInsertion();
				break;
			case 4:
				DeleteByid();
				break;
			case 5:
				UpdateData();
				break;
			case 6:
				GetByid();
				break;
			case 7:
				GetAll();
				break;
			case 8:
				System.exit(0);
				break;
			default:
				System.out.println("invalid option");
				break;
				
			}
			}while(choice>0);
	}

	private static void GetAll() {
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(driver);
			System.out.println("enter the database name");
			String url="jdbc:mysql://localhost:3306/"+src.next();
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("enter table name");
			
			String sql="select * from "+src.next();
			pmst=conn.prepareStatement(sql);
		    ResultSet rs=pmst.executeQuery();
		    while(rs.next()) {
		    	System.out.println("order_id :"+rs.getLong("order_id"));
		    	System.out.println("order_name:"+rs.getString("order_name"));
		    	System.out.println("order_pincode:"+rs.getInt("order_pincode"));
		    	System.out.println("order_address:"+rs.getString("order_address"));
		    }
			
			pmst.close();
			conn.close();
			}
		catch(Exception e) {
			e.printStackTrace();
			}
		
		
	}

	private static void GetByid() {
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(driver);
			System.out.println("enter the database name");
			String url="jdbc:mysql://localhost:3306/"+src.next();
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("enter table name");
			String sql="select * from "+src.next()+" where order_id=?";
			pmst=conn.prepareStatement(sql);
			System.out.println("enter order_id");
			pmst.setLong(1,src.nextLong());
		    ResultSet rs=pmst.executeQuery();
		    while(rs.next()) {
		    	System.out.println("order_id :"+rs.getLong("order_id"));
		    	System.out.println("order_name:"+rs.getString("order_name"));
		    	System.out.println("order_pincode:"+rs.getInt("order_pincode"));
		    	System.out.println("order_address:"+rs.getString("order_address"));
		    }
			
			pmst.close();
			conn.close();
			}
		catch(Exception e) {
			e.printStackTrace();
			}
		
		
	}

	private static void UpdateData() {
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(driver);
			System.out.println("enter database name to update data");
			String url="jdbc:mysql://localhost:3306"+src.next();
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("enter database table name");
			
			String sql="update  "+src.next() + "set order_name=?,order_pincode=?,order_address=? where order_id=?";
			pmst=conn.prepareStatement(sql);
			
			System.out.println("enter order name");
			pmst.setString(1, src.next());
			System.out.println("enter order pin code");
			pmst.setInt(2,src.nextInt());
			System.out.println("enter order adress");
	        pmst.setString(3,src.next());
	        System.out.println("enter order id");
			pmst.setLong(4, src.nextLong());
			
			int i=pmst.executeUpdate();
			if(i>0) {
				System.out.println("database inserted successfully");
			}else{
				System.out.println("database is not inserted");
			}
			pmst.close();
			conn.close();}
		catch(Exception e) {
			e.printStackTrace();}
		
	}

	private static void DeleteByid() { 
		try {
			Scanner src = new Scanner(System.in);
			Class.forName(driver);
			System.out.println("Enter Database name to insert data");
			String url = "jdbc:mysql://localhost:3306/"+ src.next();
			conn  = DriverManager.getConnection(url, username, password);
			System.out.println("Enter Database table name");
			String sql = "delete from "+src.next() + " where order_id=? ";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter order id");
			pmst.setLong(1, src.nextLong());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("Database deleted Successfully");
			}else {
				System.out.println("Database Not deleted...!");
			}
			conn.close();
			pmst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		
	}

	private static void DataInsertion() {
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(driver);
			System.out.println("enter database name to insert data");
			String url="jdbc:mysql://localhost:3306"+src.next();
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("enter database table name");
			
			String sql="insert into "+src.next() + "(order_id,order_name,order_pincode,order_adress)values(?,?,?,?)";
			pmst=conn.prepareStatement(sql);
			System.out.println("enter order id");
			pmst.setLong(1, src.nextLong());
			System.out.println("enter order name");
			pmst.setString(2, src.next());
			System.out.println("enter order pin code");
			pmst.setInt(3,src.nextInt());
			System.out.println("enter order adress");
	        pmst.setString(4,src.next());
			
			int i=pmst.executeUpdate();
			if(i>0) {
				System.out.println("database inserted successfully");
			}else{
				System.out.println("database is not inserted");
			}
			pmst.close();
			conn.close();}
		catch(Exception e) {
			e.printStackTrace();}
		
		
	}

	private static void DropDatabse() {
		try {
			Class.forName(driver);
			String url="jdbc:mysql://localhost:3306";
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("enter database name");
			Scanner src=new Scanner(System.in);
			String sql="drop database "+src.next();
			pmst=conn.prepareStatement(sql);
			int i=pmst.executeUpdate();
			if(i==0) {
				System.out.println("database dropped successfully");
			}else{
				System.out.println("database is not dropped");
			}
			pmst.close();
			conn.close();}
		catch(Exception e) {
			e.printStackTrace();}
		
		
	}

	private static void CreateDatabse() {
		try {
			Class.forName(driver);
			String url="jdbc:mysql://localhost:3306";
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("enter database name");
			Scanner src=new Scanner(System.in);
			String sql="create database "+src.next();
			pmst=conn.prepareStatement(sql);
			int i=pmst.executeUpdate();
			if(i>0) {
				System.out.println("database created successfully");
			}else{
				System.out.println("database is not created");
			}
			pmst.close();
			conn.close();}
		catch(Exception e) {
			e.printStackTrace();
			}
		
	}

	private static void DisplayMenu() {
		System.out.println("\t1.create database");
		System.out.println("\t2.drop database");
		System.out.println("\t3.data insertion");
		System.out.println("\t4.delete by id");
		System.out.println("\t5.update data");
		System.out.println("\t6.get by id");
		System.out.println("\t7.get all");
		System.out.println("\t8.exit");
		// TODO Auto-generated method stub
		
	}

}
