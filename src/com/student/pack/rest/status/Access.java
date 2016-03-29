package com.student.pack.rest.status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.student.pack.rest.status.Student;

import com.student.pack.dao.Login;

//import dto.Course;
//import dto.Login;
//import dto.StudentCourses;
//import dto.SearchInfo;

/**
 * Implements methods to Access the DB
 * @author swethamuchukota
 *
 */
 
public class Access 
{
	Login loginObj = new Login();
	//loginObj.setStudentid (1111);
	
	//default value of term which is current term
	String term = "FALL 2015" ;
	
	
	/**
	 * getCredentials gets credentials from DB table Login for the given user name
	 * @param con first parameter, connection to DB
	 * @param username second parameter, username of the currentuser to query DB
	 * @return Login object with all values set from DB
	 * @throws SQLException
	 */
    public Login getCredentials(Connection con,String username) throws SQLException
	{
    	
    	con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
    	
		PreparedStatement stmt = con.prepareStatement("SELECT StudentID,Password from login where username = ? LOCK IN SHARE MODE");
		stmt.setString(1, username);
		loginObj.setUname(username);
		
		try {
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				this.loginObj.setStudentid(rs.getInt("StudentID"));
				this.loginObj.setPassword(rs.getString("Password"));
			}
			
			rs.close();
			
			con.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
			
		} catch (SQLException e)
		{
		     e.printStackTrace();
		     
		}
		return loginObj;
	}
	
    
    
	
	/* Fetches details of a particular student
     * @param con
     * @param id
     * @return
     * @throws SQLException
     */
    
    public Student getStudentDetails(Connection con, int id) throws SQLException
    {
        con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        Student st = new Student();
    	PreparedStatement stmt = con.prepareStatement("Select StudentID,FirstName,LastName,DateOfBirth,DeptCode,CGPA from Student where StudentID = ?");
    	stmt.setInt(1, id);
    	
    	try {
    		ResultSet rs = stmt.executeQuery();
    		while(rs.next()) {
    			st.setDate_birth(rs.getString("DateOfBirth"));
    			st.setStudentID(rs.getInt("StudentID"));
    			st.setCgpa(rs.getFloat("CGPA"));
    			st.setDept_code(rs.getString("DeptCode"));
    			st.setFirst_name(rs.getString("FirstName"));
    			st.setLast_name(rs.getString("LastName"));
    		}
    		con.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
    		return st;
    		
    	}catch (Exception e)
    	{
    		return st;
    	}
    }
    
    /**
     * Gets all Students details
     * @param con
     * @param id
     * @return
     * @throws SQLException
     */
    public ArrayList<Student> getStudentsDetails(Connection con) throws SQLException
    {
        con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        ArrayList <Student> students = new ArrayList<Student> ();
        
    	PreparedStatement stmt = con.prepareStatement("Select StudentID,FirstName,LastName,DateOfBirth,DeptCode,CGPA from Student LOCK IN SHARE MODE");
    	
    	try {
    		ResultSet rs = stmt.executeQuery();
    		while(rs.next()) {
    			Student st = new Student();
    			st.setDate_birth(rs.getString("DateOfBirth"));
    			st.setStudentID(rs.getInt("StudentID"));
    			st.setCgpa(rs.getFloat("CGPA"));
    			st.setDept_code(rs.getString("DeptCode"));
    			st.setFirst_name(rs.getString("FirstName"));
    			st.setLast_name(rs.getString("LastName"));
    			students.add(st);
    		}
    		con.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
    		return students;
    		
    	}catch (Exception e)
    	{
    		return students;
    	}
    }

    
   
    
    
    
}

    