package com.student.pack.rest.status;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Database {

	/**
	getConnection() method is used to setup connection
	@param ip This is the first parameter and is used to form connection url
	@param port This is the second parameter,this is port of MySQL
	@param user This is the third parameter,username to connect to MySQL
	@param pword This is the fourth parameter,password of the user to connect to MySQL
	@return connection This return connection to MySQL DB 
	@throws SQLException on failed to create connection and Exception if mysql.jdbc.driver class is not found
	*/

  public Connection getConnection() throws Exception,SQLException
	{
		
	    PreparedStatement stmt=null;
		Connection conn=null;
		
		try
	    {
	      // create our mysql database connection
	      String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost/mysql";
	      Class.forName(myDriver);
	      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reg?user=root&password=root");
	       }catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    
		return conn;
	   
	}
	  
	  
	  /*try
		{     Connection conn=null;
			  String myDriver = "com.mysql.jdbc.Driver";
		      String myUrl = "jdbc:mysql://localhost:3306/mysql";
		      Class.forName(myDriver);
		      conn = DriverManager.getConnection(myUrl, "root", "admin");
			return conn;
		} catch (SQLException e)
		{
		   throw e;
		}
		catch (Exception e)
		{
			throw e;
		}
	 
	}*/
  
  /**
   * getConnection returns connection to the DB hosted on a machine with IP address
   * @param ip IP address of the machine that hosts DB
   * @param port MySQL port
   * @param uname username to connect to DB
   * @param pword password to connect to DB
   * @return Connection to DB
   * @throws Exception
   * @throws SQLException
   */
  
 /* public Connection getConnection(String ip,String port,String uname,String pword) throws Exception,SQLException
	{
		try
		{
			Connection conn=null;
			  String myDriver = "com.mysql.jdbc.Driver";
		      String myUrl = "jdbc:mysql://localhost:3306/mysql";
		      Class.forName(myDriver);
		      conn = DriverManager.getConnection(myUrl, "root", "admin");
			return conn;
		} catch (SQLException e)
		{
		   throw e;
		}
		catch (Exception e)
		{
			throw e;
		}
	 
	}*/
	 
}
	
	
