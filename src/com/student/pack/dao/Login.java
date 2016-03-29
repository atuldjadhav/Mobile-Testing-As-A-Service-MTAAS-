package com.student.pack.dao;


/** 
 * Class to hold login objects
 * @author Swetha Muchukota
 *
 */
public class Login {
	
	String uname="";
	String password="";
	String accounttype;
	int Studentid;
	
	/** default constructor
	 * 
	 */
	public Login()
	{
		
	}
	
	/** user defined Constructor for login objects
	 * 
	 * @param user First parameter to set username of login object
	 * @param pword Second parameter to set password of login object
	 * @param type third parameter type of the login account (Student/Instructor/Admin)
	 * @param id fourth parameter id of the login object
	 */
	
	public Login(String user,String pword,String type,int id){
		this.uname = user;
		this.password =pword;
		this.accounttype =type;
		this.Studentid = id;
	}
 
	/**
	 * getUname - To get username of login object
	 * @return current uname 
	 */
	public String getUname() {
		return uname;
	}
	
	/**setUname - to set username(uname) of login object
	 * @param uname uname to set
	 */

	public void setUname(String uname) {
		this.uname = uname;
	}
	
	/**
	 * getpassword - To get password of login object
	 * @return current password
	 */

	public String getPassword() {
		return password;
	}
    
	/**
	 * setpassword - To set password of login object
	 * @param password password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * getAccounttype - To get Accounttype of login object
	 * @return current Accounttype
	 */
	public String getAccounttype() {
		return accounttype;
	}
	/**
	 * setAccounttype - To set account type of login object
	 * @param accounttype accounttype to set
	 */

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	/**
	 * getStudent- To get studentid of login object
	 * @return current studentid
	 */
	public int getStudentid() {
		return Studentid;
	}
	
	/**
	 * setstudentid - To set studentid of login object
	 * @param studentid studentid to set
	 */

	public void setStudentid(int studentid) {
		Studentid = studentid;
	}
	
	

}
