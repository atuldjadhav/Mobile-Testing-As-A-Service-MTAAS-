package com.student.pack.rest.status;

import java.sql.Connection;
//import java.sql.SQLException;
import java.util.ArrayList;

import com.student.pack.rest.status.Student;
import com.student.pack.rest.status.Access;
import com.student.pack.rest.status.Database;

import com.student.pack.dao.Login;

 
public class Accessmanger 
{
	Connection con;
	Access access = new Access();
	Database db = new Database();
	
	
	
	/**
	 * Default Constructor 
	 * @throws Exception
	 */
	
	public Accessmanger() throws Exception
	{
		con = db.getConnection();
	}
	
	
	/**
	 * To fetch credentials from DB
	 * @param username
	 */
	
    public Login fetchCredentials(String username) throws Exception {
    	 
    	  Login obj = access.getCredentials(con, username);
    	  return obj;
	}
	
	
	/**
	 * Gets details of a Particular Student
	 * @param studentid
	 * @return Student Object with all required details
	 * @throws Exception
	 */
	public Student getStudentDetails(int studentid) throws Exception
	{
		return access.getStudentDetails(con, studentid);
		
	}
	
	public ArrayList<Student> getStudentsDetails() throws Exception {
		return access.getStudentsDetails(con);
	}
	
	
}