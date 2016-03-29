package com.student.pack.rest.status;




/**
 * class to bind Student entity in DB
 * @author swethamuchukota
 *
 */

public class Student {
  int StudentID;
  String first_name;
  String last_name;
  String date_birth;
  String dept_code;
  String Enrolled_year;
  float  cgpa;
  Link link = new Link();
 
  
  public Student( )
  {
	  
  }
  public Student (int sid,String fname,String lname,String dob,String dcode,String eyear,float cgpa)
  {
       this.StudentID = sid;
       this.first_name = fname;
       this.last_name=lname;
       this.date_birth=dob;
       this.dept_code=dcode;
       this.Enrolled_year=eyear;
       this.cgpa =cgpa;
       
  }

public int getStudentID() {
	return StudentID;
}

public void setStudentID(int studentID) {
	StudentID = studentID;
}

public String getFirst_name() {
	return first_name;
}

public void setFirst_name(String first_name) {
	this.first_name = first_name;
}

public String getLast_name() {
	return last_name;
}

public void setLast_name(String last_name) {
	this.last_name = last_name;
}

public String getDate_birth() {
	return date_birth;
}

public void setDate_birth(String date_birth) {
	this.date_birth = date_birth;
}

public String getDept_code() {
	return dept_code;
}

public void setDept_code(String dept_code) {
	this.dept_code = dept_code;
}

public String getEnrolled_year() {
	return Enrolled_year;
}

public void setEnrolled_year(String enrolled_year) {
	Enrolled_year = enrolled_year;
}

public float getCgpa() {
	return cgpa;
}

public void setCgpa(float cgpa) {
	this.cgpa = cgpa;
}
  

public String tostring ()
  {
	  return "Student [ id = " +StudentID+" , Name= "+first_name+"  "+last_name+", Dept = "+dept_code+"]";
  }
public Link getLink() {
	return link;
}
public void setLink(Link link) {
	this.link = link;
}
public int hashcode() {
	// TODO Auto-generated method stub
	int fname = 31 * (first_name.hashCode());
	int lname = 31 * (last_name.hashCode());
	int cgpa1 = (int) (31 * (this.getCgpa()));
	return fname+lname+cgpa1;
}


  
}
