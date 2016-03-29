package com.student.pack.dao;

public class DatabaseConnect {
	
	public int insertAdduser(String UserType, String Email, String Username, String Password,String first_name,String Last_name,String Gender, String Phone_no){
		
		
		int http_code=0;
		
		return http_code;
	}
	
	
	
}























/*package com.student.pack.dao;


import java.sql.*;

import org.codehaus.jettison.json.JSONArray;

import com.student.util.*;
import com.student.pack.rest.status.*;

*//**
 * 
 * @author sista
 *
 *//*

public class DatabaseConnect {
	
	
	*
	 * fetch details related to a specific course name
	 * 
	 * @param coursename 
	 * @return
	 * @throws Exception
	 
	
	
	public JSONArray queryReturnCoursename(String coursename) throws Exception{
		PreparedStatement stmt=null;
		ConvertToJSON conv=new ConvertToJSON();
	      JSONArray json=new JSONArray();
		Connection conn=null;
		Database db=new Database();
		
		
		
	    try
	    {
	      
	      stmt = db.getConnection().prepareStatement("SELECT course.coursecode, course.coursename,course.credits, section.sectionid,section.location,section.price,section.starttime"+ 
" from course left join section on section.coursecode=course.coursecode where course.coursename= ?");
	      
	      stmt.setString(1,coursename);
	      ResultSet rs = stmt.executeQuery();
	       
	      json=conv.toJSONArray(rs);
	      stmt.close();
	     
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    finally{
	    	if(conn !=null) conn.close();
	    }
	    return json;
	}
	
	*//**
	 * fetch details of courses from database with respect to price 
	 * @param price
	 * @return
	 * @throws Exception
	 *//*
	
	
	public JSONArray queryReturnCourseWithPrice(String price) throws Exception{
		PreparedStatement stmt=null;
		ConvertToJSON conv=new ConvertToJSON();
	      JSONArray json=new JSONArray();
		Connection conn=null;
		Database db=new Database();
		
		
		
	    try
	    {
	      
	      stmt = db.getConnection().prepareStatement("SELECT course.coursecode, course.coursename,course.credits, section.sectionid,section.location,section.price,section.starttime"+ 
" from course left join section on section.coursecode=course.coursecode where section.price< ?");
	      
	      stmt.setString(1,price);
	      ResultSet rs = stmt.executeQuery();
	       
	      json=conv.toJSONArray(rs);
	      stmt.close();
	     
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    finally{
	    	if(conn !=null) conn.close();
	    }
	    return json;
	}
	
	

*//**
 * fetch details of courses from database with respect to starttime of the course
 * @param starttime
 * @return
 * @throws Exception
 *//*



public JSONArray queryByTime(String starttime) throws Exception {
	
	PreparedStatement stmt = null;
	Connection conn = null;
	ConvertToJSON conv=new ConvertToJSON();
    JSONArray json=new JSONArray();
    Database db=new Database();
	
	try {
		
	
	      
		stmt = db.getConnection().prepareStatement("SELECT course.coursecode, course.coursename,course.credits, section.sectionid,section.location,section.price,section.starttime"+ 
" from course left join section on section.coursecode=course.coursecode where section.starttime= ? ");
										
          stmt.setString(1, starttime);
	      
	      ResultSet rs = stmt.executeQuery();
	      json=conv.toJSONArray(rs);
	      
	       stmt.close();
	     
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    finally{
	    	if(conn !=null) conn.close();
	    }
	    return json;
	}

*//**
 * fetch details of courses from database with respect to location
 * @param location
 * @return
 * @throws Exception
 *//*



public JSONArray queryByLocation(String location) throws Exception {
	
	PreparedStatement stmt = null;
	Connection conn = null;
	ConvertToJSON conv=new ConvertToJSON();
      JSONArray json=new JSONArray();
      Database db=new Database();
	
	try {
		
		stmt = db.getConnection().prepareStatement("SELECT course.coursecode, course.coursename,course.credits, section.sectionid,section.location,section.price,section.starttime"+ 
" from course left join section on section.coursecode=course.coursecode where section.location= ?");
		
		  stmt.setString(1, location);
	      
	      ResultSet rs = stmt.executeQuery();
	       
	     json=conv.toJSONArray(rs);
	      
	      
	      stmt.close();
	     
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    finally{
	    	if(conn !=null) conn.close();
	    }
	    return json;
	}


*//**
 * fetch details of courses from database with respect to price,location, starttime, coursename
 * @param location
 * @param price
 * @param starttime
 * @param Course
 * @return
 * @throws Exception
 *//*


public JSONArray queryBy4Parameters(String location ,int price,String starttime,String Course) throws Exception {
	
	PreparedStatement stmt = null;
	Connection conn = null;
	ConvertToJSON conv=new ConvertToJSON();
      JSONArray json=new JSONArray();
      Database db=new Database();
      System.out.println(location+price+starttime+Course);
	
	try {
		
		stmt = db.getConnection().prepareStatement("SELECT course.coursecode, course.coursename,course.credits, section.sectionid,section.location,section.price,section.starttime "
				+ "from course left join section on section.coursecode=course.coursecode where section.location= ? and section.starttime=? and section.price<? and course.coursename=?");
	      
		System.out.println(stmt);
		
		 stmt.setString(1, location);
	     stmt.setString(2, starttime);
	     stmt.setInt(3, price);
	     stmt.setString(4, Course);
	      
	      
	      ResultSet rs = stmt.executeQuery();
	     
	      json=conv.toJSONArray(rs);
	      
	      
	  	rs.close();
	       
	    stmt.close();
	     
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	System.out.println("In Catch");
	    }
	    finally{
	    	if(conn !=null) conn.close();
	    }
	
	    return json;
	}


*//**
 * fetch number of courses from database which the student registered with respect to studenetid 
 * @param studentid
 * @return
 * @throws Exception
 *//*
	
public JSONArray queryBy3Parameter(String location ,int price,String Course) throws Exception {
	
	PreparedStatement stmt = null;
	Connection conn = null;
	ConvertToJSON conv=new ConvertToJSON();
      JSONArray json=new JSONArray();
      Database db=new Database();
      System.out.println(location+price+Course);
	
	try {
		
		stmt = db.getConnection().prepareStatement("SELECT course.coursecode, course.coursename,course.credits, section.sectionid,section.location,section.price,section.starttime "
				+ "from course left join section on section.coursecode=course.coursecode where section.location= ? and section.price<? and course.coursename=?");
	      
		System.out.println(stmt);
		
		 stmt.setString(1, location);
	     
	     stmt.setInt(2, price);
	     stmt.setString(3, Course);
	      
	      
	      ResultSet rs = stmt.executeQuery();
	     
	      json=conv.toJSONArray(rs);
	      
	      
	  	rs.close();
	       
	    stmt.close();
	     
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	System.out.println("In Catch");
	    }
	    finally{
	    	if(conn !=null) conn.close();
	    }
	
	    return json;
	}

	
	
	   
	  
	public JSONArray queryReturnNumberOfCourses(int studentid) throws Exception{
		PreparedStatement stmt=null;
		ConvertToJSON conv=new ConvertToJSON();
	      JSONArray json=new JSONArray();
	      Connection conn=null;
	      Database db=new Database();
		
		
		
	    try
	    {
	      
	      
	    stmt = db.getConnection().prepareStatement("SELECT COUNT(studentid) FROM studentcourses where studentid=?");
	      stmt.setInt(1, studentid);;
	      ResultSet rs = stmt.executeQuery();
	       
	      json=conv.toJSONArray(rs);
	      stmt.close();
	     
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    finally{
	    	if(conn !=null) conn.close();
	    }
	    return json;
	}
	
	
	
	
	
	public JSONArray queryCurrentCoursesEnrolled(int studentid) throws Exception{
		PreparedStatement stmt=null;
		ConvertToJSON conv=new ConvertToJSON();
	      JSONArray json=new JSONArray();
		Connection conn=null;
		Database db=new Database();
		
		
		
	    try
	    {
	      
	      
	      stmt = db.getConnection().prepareStatement("SELECT * FROM studentcourses where studentid=?");
	      
	      stmt.setInt(1, studentid);;
	      ResultSet rs = stmt.executeQuery();
	       json=conv.toJSONArray(rs);
	      
	      
	      stmt.close();
	     
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    finally{
	    	if(conn !=null) conn.close();
	    }
	    return json;
	}
	
	
	
	
	
	   
	  
	public int insertAddCourses(int studentid,int sectionid,String coursecode,String term,String grade ) throws Exception{
		PreparedStatement stmt=null;
		Connection conn=null;
		Database db=new Database();
		
		
		
	    try
	    {
	      
	      
	      stmt = db.getConnection().prepareStatement("insert into studentcourses(studentid,sectionid,coursecode,term,grade)values(?,?,?,?,?)");
	      
          stmt.setInt(1, studentid);
	      stmt.setInt(2, sectionid);
	      stmt.setString(3, coursecode);
	      stmt.setString(4, term);
	      stmt.setString(5, grade);
	      
	      stmt.executeUpdate();
	       
	       }catch(Exception e){
	    	e.printStackTrace();
	    	return 500;
	    	
	    }
	    finally{
	    	if(conn !=null) conn.close();
	    }
	    return 200;
	}
	
	
public JSONArray dropCourses(int studentid, String coursecode,int sectionid) throws Exception {
		
		PreparedStatement stmt = null;
		Connection conn = null;
		
	   JSONArray json=new JSONArray();
	   Database db=new Database();
		
		try {
			
			
	stmt = db.getConnection().prepareStatement("delete from studentcourses " +
											"where studentid = ? AND coursecode = ? and sectionid=?");
			
			
			
			// execute the query, and get a java resultset
		      stmt.setInt(1, studentid);
		      stmt.setString(2, coursecode);
		      stmt.setInt(3, sectionid);
		      
		      stmt.executeUpdate();
		  
		      // iterate through the java resultset
		      
		      
		      
		      
		      stmt.close();
		     
		      
		    }catch(Exception e){
		    	e.printStackTrace();
		    	
		    }
		    finally{
		    	if(conn !=null) conn.close();
		    }
		    return json;
		}



	   
public static boolean loginCheck(String uname,String password) throws Exception{
	boolean userIsAvailable=false;
	Statement stmt = null;
	Connection conn = null;
	
	try{
		try{
			 String myDriver = "com.mysql.jdbc.Driver";
		      String myUrl = "jdbc:mysql://localhost/reg";
		      Class.forName(myDriver);
		      conn = DriverManager.getConnection(myUrl, "root", "root");
		}catch(Exception e){
			e.printStackTrace();
		}
		stmt=conn.createStatement();
		String query="Select * from login where username="+"'" + uname +"'AND password="+"'"+password +"'";
		System.out.println(query);
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()){
			userIsAvailable=true;
			
		}
	} catch(SQLException sqle){
		throw sqle;
	}catch(Exception e){
		if(conn != null){
			conn.close();
		}
		throw e;
	} finally {
		if(conn !=null){
			conn.close();
		}
	}
	return userIsAvailable;
	
}





	



}
*/