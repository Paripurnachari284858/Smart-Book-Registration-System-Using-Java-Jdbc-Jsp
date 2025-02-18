package com.bookshopproject.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bookshopproject.Entity.BookData;

//this Dao class in which we write the jdbc code 
public class Dao {
	//Mysql driver 
	public String driver="com.mysql.cj.jdbc.Driver";
	//location of mysql in system
	public String url="jdbc:mysql://localhost:3306/javadb";
	public String user="root";
	//mysql password
	public String password="password";
	Connection conn=null;
	//statement for static query's
	Statement st=null;
	PreparedStatement ps=null;
	ResultSet rs=null;

	//this Method for inserting data into table submitted By BookShop Admin from form.
	public void insertData(BookData bd)
	{
		//loading the Driver
		try {
			Class.forName(driver);
			//Establishing the connection from java program to Database
			conn=DriverManager.getConnection(url, user, password);
			//creating statement objects for passing sql querys
			//query for inserting data
			String query="insert into bookdata(bname,bedition,bauthor,bgenre,bprice) values(?,?,?,?,?);";
			ps=conn.prepareStatement(query);
			//giving data to positional parameters based on index
			ps.setString(1,bd.getBname());
			ps.setString(2,bd.getBedition());
			ps.setString(3,bd.getBauthor());
			ps.setString(4,bd.getBgenre());
			ps.setInt(5, bd.getBprice());
			//executing sql query
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			System.out.println("Driver Class is Not found");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DataBase connection is Not established");
			e.printStackTrace();
		}
		finally
		{
			//closing the connections
			if(ps!=null && conn!=null)
			{
				try {
					ps.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//display All data into the table
	public ArrayList<BookData> displayData()
	{
		ArrayList<BookData> al=new ArrayList<BookData>();
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
			st=conn.createStatement();
			//getting All table data from table
			rs=st.executeQuery("select * from bookdata");
			while(rs.next())
			{
				//
				int bid=rs.getInt(1);
				String bName=rs.getString(2);
				String bEdition=rs.getString(3);
				String bAuthor=rs.getString(4);
				String bGenre=rs.getString(5);
				int bPrice=rs.getInt(6);
				BookData bd1=new BookData(bid,bName,bEdition,bAuthor,bGenre,bPrice);
				al.add(bd1);

			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver class is Not Found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Databse connection is not esatablished");
			e.printStackTrace();
		}
		finally
		{
			//closing the connections
			if(rs!=null&&st!=null&&conn!=null)
			{
				
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		return al;

	}



public ArrayList<BookData> getBookRecord(BookData bd)
{
	ArrayList<BookData> al=new ArrayList<BookData>();
	
	try {
		Class.forName(driver);
		conn=DriverManager.getConnection(url,user,password);
		ps=conn.prepareStatement("select * from bookdata where bid=?");
		ps.setInt(1,bd.getBid());
		rs=ps.executeQuery();
		if(rs.next())
		{
			int bid=rs.getInt("bid");
			String bname=rs.getString("bname");
			String bedition=rs.getString("bedition");
			String bauthor=rs.getString("bauthor");
			String bgenre=rs.getString("bname");
			int bprice=rs.getInt("bprice");
			BookData bd1=new BookData(bid,bname,bedition,bauthor,bgenre,bprice);
			al.add(bd1);
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		//closing the connections
		if(rs!=null&&ps!=null&&conn!=null)
		{
			
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	return al;
	
}
//update the book Record
public void getUpdatebookRecord(BookData bd)
{
	try {
		Class.forName(driver);
		conn=DriverManager.getConnection(url,user,password);
		ps=conn.prepareStatement("update bookdata set bname=?,bedition=?,bauthor=?,bgenre=?,bprice=? where bid=?");
		ps.setString(1,bd.getBname());
		ps.setString(2,bd.getBedition());
		ps.setString(3,bd.getBauthor());
		ps.setString(4,bd.getBgenre());
		ps.setInt(5,bd.getBprice());
		ps.setInt(6,bd.getBid());
		ps.executeUpdate();
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
	  System.out.println("Driver Class is Not Found");
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Database connection is not established");
		e.printStackTrace();
	}
	finally
	{
		//closing the connections
		if(ps!=null && conn!=null)
		{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
/*public void getDeleteBookRecord(BookData bd)
{
	try {
		Class.forName(driver);
		conn=DriverManager.getConnection(url,user,password);
		ps=conn.prepareStatement("delete from bookdata where bid=?");
		ps.setInt(1, bd.getBid());
		ps.executeUpdate();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		 System.out.println("Driver Class is Not Found");
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Database connection is not established");
		e.printStackTrace();
	}
	finally
	{
		//closing the connections
		if(ps!=null && conn!=null)
		{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}*/
public boolean getDeleteBookRecord(BookData bd) {
    String query = "DELETE FROM bookdata WHERE bid = ?";
    boolean isDeleted = false;

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement ps = conn.prepareStatement(query)) {

        ps.setInt(1, bd.getBid()); // Set the bid in the prepared statement
        int rowsAffected = ps.executeUpdate(); // Execute the delete operation

        isDeleted = rowsAffected > 0; // True if at least one record was deleted

    } catch (SQLException e) {
        System.out.println("Database connection or query execution failed.");
        e.printStackTrace();
    }

    return isDeleted; // Return true if record was deleted
}

}
