package com.student.pack.rest.status;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.student.pack.rest.status.Accessmanger;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;







import java.net.URI;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.student.util.ConvertToJSON;
import com.student.pack.dao.*;
import com.student.pack.rest.status.Link;
import com.student.pack.rest.status.Student;
import com.student.pack.rest.status.Students;
import com.mongodb.client.MongoDatabase;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/cloudrest")
public class Student_reststatus {
 
	@Path("/login")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginCheck(@QueryParam("user") String username) throws Exception{
		
		
		 // To connect to mongodb server
	
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
         JSONArray json=new JSONArray();
         // Now connect to your databases
         @SuppressWarnings({ "deprecation" })
		DB db = mongoClient.getDB( "local" );
         System.out.println("Connect to database successfully");
        // mongoClient.setWriteConcern(WriteConcern.ACKNOWLEDGED);
		String returnString=null;
		JSONArray jsonArray=new JSONArray();		
	    try
	    { 
	
		 DBCollection  tb = db.getCollection("user_details");
		 BasicDBObject query = new BasicDBObject("user_name",username);
		 System.out.println(username);
		 DBCursor cursor = tb.find(query);
		 try {
			   while(cursor.hasNext()) {
			      returnString= cursor.next().toString();
			      System.out.println(returnString);
			   }
			} finally {
			   cursor.close();
			}
		
      
    }catch(Exception e){
    	e.printStackTrace();
    	return Response.status(500).entity("Server cannot able to process request").build();
    	
    }
   // System.out.println(Response.ok(returnString).build());
     return Response.ok(returnString).build(); 
	}
	@Path("/testhistory")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response testhistory(@QueryParam("user") String username) throws Exception{
		
		
		 // To connect to mongodb server
		StringBuilder res = new StringBuilder(1000);
		String res2=null;
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
         JSONArray json=new JSONArray();
         // Now connect to your databases
         @SuppressWarnings({ "deprecation" })
		DB db = mongoClient.getDB( "local" );
         System.out.println("Connect to database successfully");
         System.out.println(username);
        // mongoClient.setWriteConcern(WriteConcern.ACKNOWLEDGED);
		String returnString=null;
		JSONArray jsonArray=new JSONArray();		
	    try
	    { 
	
		 DBCollection  tb = db.getCollection("user_details");
		 BasicDBObject query = new BasicDBObject("user_name",username);
		 DBCursor cursor = tb.find(query);
		 try {
			   while(cursor.hasNext()) {
				   returnString= (String) cursor.next().get("User_Id");
				   System.out.println(returnString);
			   }
			} finally {
			   cursor.close();
			} 
		 String comma=",";
		 String fbracket="[";
		 String lbracket="]";
		
	 DBCollection  tb2 = db.getCollection("resulttable");
	 BasicDBObject query2 = new BasicDBObject();
	 query2.put("tester_id",returnString);
	 DBCursor cursor2 = tb2.find(query2);
	 
	 try {
		   while(cursor2.hasNext()) {
		      returnString= cursor2.next().toString();
		     System.out.println(returnString);
		     res = res.append(returnString).append(comma);
		     
		   }
		  res.setLength(res.length() - 1);
		   String result= fbracket+res+lbracket;
		   res2 = result.toString();
		   System.out.println(res2);  
		   
		} finally {
		   cursor.close();
		}
	
  	
      
    }catch(Exception e){
    	e.printStackTrace();
    	return Response.status(500).entity("Server cannot able to process request").build();
    	
    }
   // System.out.println(Response.ok(returnString).build());
     return Response.ok(res2).build(); 
	}
	@Path("/assigntester")
	
	  
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response assignTester() throws Exception{
		
		
		 // To connect to mongodb server

         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
         JSONArray json=new JSONArray();
         // Now connect to your databases
         @SuppressWarnings({ "deprecation" })
		DB db = mongoClient.getDB( "local" );
         System.out.println("Connect to database successfully");
        // mongoClient.setWriteConcern(WriteConcern.ACKNOWLEDGED);
		String returnString=null;
		JSONArray jsonArray=new JSONArray();	
		StringBuilder res = new StringBuilder(1000);
		String res2=null;
	    try
	    { 
	
		System.out.println("Inside result");
		 DBCollection  tb = db.getCollection("Applicationdetails");
		 BasicDBObject query = new BasicDBObject();
		 query.put("status_id","1");
		 DBCursor cursor = tb.find(query);
		 String comma=",";
		 String fbracket="[";
		 String lbracket="]";
		 try {
			   while(cursor.hasNext()) {
				   
			      returnString= cursor.next().toString();
			      System.out.println(returnString);
			      res = res.append(returnString).append(comma);
			     
			   }
			  res.setLength(res.length() - 1);
			   String result= fbracket+res+lbracket;
			   res2 = result.toString();
			   System.out.println(res2);
			} finally {
			   cursor.close();
			}
		
	 
      
    }catch(Exception e){
    	e.printStackTrace();
    	return Response.status(500).entity("Server cannot able to process request").build();
    	
    }
  
	// System.out.println(Response.ok(returnString).build());
     return Response.ok(res2).build(); 
	}
	  
	
	@Path("/getResult")
	
	  
	
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response getResult(@QueryParam("user") String username) throws Exception{
			
			
			 // To connect to mongodb server

	         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	         JSONArray json=new JSONArray();
	         // Now connect to your databases
	         @SuppressWarnings({ "deprecation" })
			DB db = mongoClient.getDB( "local" );
	         System.out.println("Connect to database successfully");
	        // mongoClient.setWriteConcern(WriteConcern.ACKNOWLEDGED);
			String returnString=null;
			JSONArray jsonArray=new JSONArray();	
			StringBuilder res = new StringBuilder(1000);
			String res2=null;
		    try
		    { 
		
			System.out.println("Inside result");
			 DBCollection  tb = db.getCollection("resulttable");
			 BasicDBObject query = new BasicDBObject("username",username);
			 System.out.println(username);
			 DBCursor cursor = tb.find(query);
			 String comma=",";
			 String fbracket="[";
			 String lbracket="]";
			 try {
				   while(cursor.hasNext()) {
					   
				      returnString= cursor.next().toString();
				      System.out.println(returnString);
				      res = res.append(returnString).append(comma);
				     
				   }
				  res.setLength(res.length() - 1);
				   String result= fbracket+res+lbracket;
				   res2 = result.toString();
				   System.out.println(res2);
				} finally {
				   cursor.close();
				}
			
		 
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	return Response.status(500).entity("Server cannot able to process request").build();
	    	
	    }
	  
		// System.out.println(Response.ok(returnString).build());
	     return Response.ok(res2).build(); 
		}
		   
	   
	
	@Path("/updateuser")
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_JSON})
	
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(String incomdata)throws Exception{
		 // To connect to mongodb server
		System.out.println(incomdata);
		System.out.println("Inside Post function");
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			
         // Now connect to your databases
         @SuppressWarnings({ "deprecation" })
		DB db = mongoClient.getDB( "local" );
         System.out.println("In data before con "+incomdata);
         System.out.println("Connect to database successfully");
        // mongoClient.setWriteConcern(WriteConcern.ACKNOWLEDGED);
		String returnString=null;
		JSONArray jsonArray=new JSONArray();
		//Mongodb db=new Mongodb();
	      System.out.println("incomingdata: " + incomdata);
			ObjectMapper mapper=new ObjectMapper();
			Adduser adduser=mapper.readValue(incomdata,Adduser.class);
			 DBCollection  tb = db.getCollection("user_details");
		//int http_code=db.insertAdduser(adduser.UserType, adduser.Email, adduser.Username, adduser.Password,adduser.first_name,adduser.Last_name,adduser.Gender, adduser.Phone_no);
			  BasicDBObject updateQuery = new BasicDBObject();
	     		updateQuery.append("$set",new BasicDBObject().append("email_id",adduser.email_id).append("first_name", adduser.first_name).append("last_name",adduser.last_name).append("password", adduser.password).append("phone_number",adduser.phone_number));
	     		BasicDBObject searchQuery = new BasicDBObject();
	     		searchQuery.append("user_name", adduser.user_name);

	     		tb.updateMulti(searchQuery, updateQuery);
			System.out.println("After Update");
			returnString="Success";
	      
	    
	   // System.out.println(Response.ok(returnString).build());
	     return Response.ok(returnString).build(); 
	}
	@Path("/assigntesters")
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_JSON})
	
	@Produces(MediaType.APPLICATION_JSON)
	public Response assignTesters(String incomdata)throws Exception{
		 // To connect to mongodb server
		System.out.println(incomdata);
		System.out.println("Inside Post function");
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			
         // Now connect to your databases
         @SuppressWarnings({ "deprecation" })
		DB db = mongoClient.getDB( "local" );
         System.out.println("In data before con "+incomdata);
         System.out.println("Connect to database successfully");
        // mongoClient.setWriteConcern(WriteConcern.ACKNOWLEDGED);
		String returnString=null;
		JSONArray jsonArray=new JSONArray();
		//Mongodb db=new Mongodb();
	      System.out.println("incomingdata: " + incomdata);
			ObjectMapper mapper=new ObjectMapper();
			assigntester assigntester=mapper.readValue(incomdata,assigntester.class);
			 DBCollection  tb = db.getCollection("Applicationdetails");
		//int http_code=db.insertAdduser(adduser.UserType, adduser.Email, adduser.Username, adduser.Password,adduser.first_name,adduser.Last_name,adduser.Gender, adduser.Phone_no);
			  BasicDBObject updateQuery = new BasicDBObject();
	     		updateQuery.append("$set",new BasicDBObject().append("tester_id",assigntester.tester_id).append("status_id", "2"));
	     		BasicDBObject searchQuery = new BasicDBObject();
	     		searchQuery.append("Appid", assigntester.app_id );

	     		tb.updateMulti(searchQuery, updateQuery);
	     		 DBCollection  tb2 = db.getCollection("resulttable");
	     		//int http_code=db.insertAdduser(adduser.UserType, adduser.Email, adduser.Username, adduser.Password,adduser.first_name,adduser.Last_name,adduser.Gender, adduser.Phone_no);
	     			  
	     		 BasicDBObject updateQuery2 = new BasicDBObject();
		     		updateQuery2.append("$set",new BasicDBObject().append("tester_id",assigntester.tester_id).append("status_id", "2"));
		     		BasicDBObject searchQuery2 = new BasicDBObject();
		     		searchQuery2.append("Appid", assigntester.app_id );
		     		tb2.updateMulti(searchQuery2, updateQuery2);
			System.out.println("After Update");
			returnString="Success";
	      
	    
	   // System.out.println(Response.ok(returnString).build());
	     return Response.ok(returnString).build(); 
	}
	@Path("/enterresult")
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_JSON})
	
	@Produces(MediaType.APPLICATION_JSON)
	public Response enterResult(String incomdata)throws Exception{
		 // To connect to mongodb server
		System.out.println(incomdata);
		System.out.println("Inside Post function");
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			String returnString2="";
         // Now connect to your databases
         @SuppressWarnings({ "deprecation" })
		DB db = mongoClient.getDB( "local" );
         System.out.println("In data before con "+incomdata);
         System.out.println("Connect to database successfully");
        // mongoClient.setWriteConcern(WriteConcern.ACKNOWLEDGED);
		String returnString=null;
		JSONArray jsonArray=new JSONArray();
		//Mongodb db=new Mongodb();
	      System.out.println("incomingdata: " + incomdata);
	      System.out.println("Before mapping");
			ObjectMapper mapper=new ObjectMapper();
			addResult addresult=mapper.readValue(incomdata,addResult.class);
			
			 DBCollection  tb = db.getCollection("Applicationdetails");
			/* System.out.println("Before Query");
		//int http_code=db.insertAdduser(adduser.UserType, adduser.Email, adduser.Username, adduser.Password,adduser.first_name,adduser.Last_name,adduser.Gender, adduser.Phone_no);
			 BasicDBObject query = new BasicDBObject("app_name",addresult.app_name);
			
			 DBCursor cursor = tb.find(query);
			 System.out.println("Before Try");
			 try {
				  // while(cursor.hasNext()) {
					   System.out.println("In While");
				      returnString= (String) cursor.next().get("username");
				      
				     
				      System.out.println(returnString);
				  // }
				} finally {
				   cursor.close();
				} */
			/* BasicDBObject query2 = new BasicDBObject("app_name",addresult.app_id);
			 DBCursor cursor2 = tb.find(query2);
			 System.out.println("Before Try");
			 try {
				  // while(cursor.hasNext()) {
					   System.out.println("In While");
				      returnString2= (String) cursor2.next().get("priority");
				      
				     
				      System.out.println(returnString2);
				  // }
				} finally {
				   cursor2.close();
				} */
			 DBCollection  tb2 = db.getCollection("resulttable");
			 int lowbug = Integer.parseInt(addresult.lowbugs);
			 int medbug=Integer.parseInt(addresult.mediumbugs);
			 int highbug=Integer.parseInt(addresult.highbugs);
			 int lowbugcost=Integer.parseInt(addresult.lowbugcost);
			 int medbugcost=Integer.parseInt(addresult.mediumbugcost);
			 int highbugcost=Integer.parseInt(addresult.highbugcost);
			 int Totalcost=(lowbug*lowbugcost)+(medbug*medbugcost)+(highbug*highbugcost);
			 String Totals=String.valueOf(Totalcost);
			 String Approved_flag="1";
			 BasicDBObject updateQuery = new BasicDBObject();
			 System.out.println(addresult.mediumbugs+addresult.lowbugs+addresult.highbugs);
	     		updateQuery.append("$set",new BasicDBObject().append("lowbugs",addresult.lowbugs).append("mediumbugs", addresult.mediumbugs).append("highbugs",addresult.highbugs).append("status_id", "3").append("Low", addresult.lowbugcost).append("TesterCost", Totals).append("Approved",Approved_flag ));
	     		BasicDBObject searchQuery = new BasicDBObject();
	     		searchQuery.append("Appid",addresult.app_id );

	     		tb2.updateMulti(searchQuery, updateQuery);
	     		System.out.println("After Insert");
	     		
	     		 BasicDBObject updateQuery2 = new BasicDBObject();
				 
		     		updateQuery2.append("$set",new BasicDBObject().append("status_id", "3").append("Approved",Approved_flag ));
		     		BasicDBObject searchQuery2 = new BasicDBObject();
		     		searchQuery2.append("Appid",addresult.app_id );
	     		tb.updateMulti(searchQuery2, updateQuery2);
			returnString="Success";
	   // System.out.println(Response.ok(returnString).build());
	     return Response.ok(returnString).build(); 
	}

	
	@Path("/getinfo")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getData(@QueryParam("user") String username) throws Exception{
		
		
		 // To connect to mongodb server
		System.out.println("Inside Post function");
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
         JSONArray json=new JSONArray();
         // Now connect to your databases
         @SuppressWarnings({ "deprecation" })
		DB db = mongoClient.getDB( "local" );
         System.out.println("Connect to database successfully");
         System.out.println(username);
        // mongoClient.setWriteConcern(WriteConcern.ACKNOWLEDGED);
		String returnString=null;
		JSONArray jsonArray=new JSONArray();		
	    try
	    { 
	
		 DBCollection  tb = db.getCollection("user_details");
		 BasicDBObject query = new BasicDBObject("user_name",username);
		 DBCursor cursor = tb.find(query);
		 try {
			   while(cursor.hasNext()) {
			      returnString= cursor.next().toString();
			   }
			} finally {
			   cursor.close();
			}
		
      
    }catch(Exception e){
    	e.printStackTrace();
    	return Response.status(500).entity("Server cannot able to process request").build();
    	
    }
   // System.out.println(Response.ok(returnString).build());
     return Response.ok(returnString).build(); 
	}
	  
	@Path("/getdashoard")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDashboard() throws Exception{
		
		
		 // To connect to mongodb server
		System.out.println("Inside Post function");
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
         JSONArray json=new JSONArray();
         // Now connect to your databases
         @SuppressWarnings({ "deprecation" })
		DB db = mongoClient.getDB( "local" );
         System.out.println("Connect to database successfully");
      
        // mongoClient.setWriteConcern(WriteConcern.ACKNOWLEDGED);
		String returnString=null;
		JSONArray jsonArray=new JSONArray();	
		StringBuilder res = new StringBuilder(1000);
		String res2=null;
	   
	    	
			 String comma=",";
			 String fbracket="[";
			 String lbracket="]";
	    try
	    { 
	
		 DBCollection  tb = db.getCollection("resulttable");
		 BasicDBObject query = new BasicDBObject();
		 DBCursor cursor = tb.find(query);
		 try {
			   while(cursor.hasNext()) {
			      returnString= cursor.next().toString();
			     System.out.println(returnString);
			     res = res.append(returnString).append(comma);
			     
			   }
			  res.setLength(res.length() - 1);
			   String result= fbracket+res+lbracket;
			   res2 = result.toString();
			   System.out.println(res2);  
			   
			} finally {
			   cursor.close();
			}
	    }catch(Exception e){
    	e.printStackTrace();
    	return Response.status(500).entity("Server cannot able to process request").build();
    	
    }
   // System.out.println(Response.ok(returnString).build());
     return Response.ok(res2).build(); 
	}
	
	
	
	
	@Path("/adduser")
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_JSON})
	
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser(String indata)throws Exception{
		 // To connect to mongodb server
		System.out.println("Inside Post function");
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			
         // Now connect to your databases
         @SuppressWarnings({ "deprecation" })
		DB db = mongoClient.getDB( "local" );
         System.out.println("Connect to database successfully");
        // mongoClient.setWriteConcern(WriteConcern.ACKNOWLEDGED);
		String returnString=null;
		JSONArray jsonArray=new JSONArray();
		//Mongodb db=new Mongodb();
		
		
		
		try
	    {
	      System.out.println("incomingdata: " + indata);
			ObjectMapper mapper=new ObjectMapper();
			Adduser adduser=mapper.readValue(indata,Adduser.class);
			 DBCollection  tb = db.getCollection("user_details");
			 BasicDBObject query = new BasicDBObject();
			 DBCursor cursor = tb.find(query);
			 try {
				   while(cursor.hasNext()) {
				      returnString= (String) cursor.next().get("User_Id");
				   }
				} finally {
				   cursor.close();
				}	 
			
			 int Userid=Integer.parseInt(returnString);
			 Userid=Userid+1;
			 String Userids=String.valueOf(Userid);
		//int http_code=db.insertAdduser(adduser.UserType, adduser.Email, adduser.Username, adduser.Password,adduser.first_name,adduser.Last_name,adduser.Gender, adduser.Phone_no);
			BasicDBObject doc1 = new BasicDBObject("user_type",adduser.user_type).append("email_id", adduser.email_id).append("user_name",adduser.user_name).append("password",adduser.password).append("first_name",adduser.first_name).append("last_name",adduser.last_name).append("gender",adduser.gender).append("phone_number",adduser.phone_number).append("User_Id", Userids);
		
			tb.insert(doc1);
			System.out.println("After insert");
			returnString="Success";
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	return Response.status(500).entity("Server cannot able to process request").build();
	    	
	    }
	   // System.out.println(Response.ok(returnString).build());
	     return Response.ok(returnString).build(); 
		     
	}
	@Path("/updatebilling")
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_JSON})
	
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBillings(String indata)throws Exception{
		 // To connect to mongodb server
		System.out.println("Inside Post function");
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			int Appid=0;
         // Now connect to your databases
         @SuppressWarnings({ "deprecation" })
		DB db = mongoClient.getDB( "local" );
         System.out.println("Connect to database successfully");
        // mongoClient.setWriteConcern(WriteConcern.ACKNOWLEDGED);
		String returnString=null;
		JSONArray jsonArray=new JSONArray();
		int http_code=200;
		//Mongodb db=new Mongodb();
		
		
		
		try
	    {
	      System.out.println("incomingdata: " + indata);
			ObjectMapper mapper=new ObjectMapper();

			updateBilling update=mapper.readValue(indata,updateBilling.class);
			 DBCollection  tb = db.getCollection("resulttable");
		
			 BasicDBObject updateQuery = new BasicDBObject();
	     		updateQuery.append("$set",new BasicDBObject().append("Approved","2").append("finalamount", update.amount).append("status_id",4));
	     		BasicDBObject searchQuery = new BasicDBObject();
	     		searchQuery.append("Appid", update.app_id);
	     		 BasicDBObject updateQuery2 = new BasicDBObject();
	     		tb.updateMulti(searchQuery, updateQuery);
	     		 DBCollection  tb2 = db.getCollection("Applicationdetails");
	     		updateQuery2.append("$set",new BasicDBObject().append("status_id",4).append("Approved","2"));
	     		BasicDBObject searchQuery2 = new BasicDBObject();
	     		searchQuery2.append("Appid", update.app_id);
	     		tb2.updateMulti(searchQuery2, updateQuery2);
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	return Response.status(500).entity("Server cannot able to process request").build();
	    	
	    }
		returnString="Success";
	     return Response.ok(returnString).build(); 
		      
		
		
		
		
	}

	@Path("/getpending")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPending(@QueryParam("user") String username) throws Exception{
		
		
		 // To connect to mongodb server
	
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
         JSONArray json=new JSONArray();
         // Now connect to your databases
         @SuppressWarnings({ "deprecation" })
		DB db = mongoClient.getDB( "local" );
         System.out.println("Connect to database successfully");
        // mongoClient.setWriteConcern(WriteConcern.ACKNOWLEDGED);
		String returnString=null;
		JSONArray jsonArray=new JSONArray();
		StringBuilder res = new StringBuilder(1000);
		String res2=null;
	    try
	    { 
	    	 DBCollection  tb2 = db.getCollection("user_details");
			 BasicDBObject query2 = new BasicDBObject("user_name",username);
			 DBCursor cursor2 = tb2.find(query2);
			 String comma=",";
			 String fbracket="[";
			 String lbracket="]";
			  while(cursor2.hasNext()) {
			      returnString= (String) cursor2.next().get("User_Id");
			  }
		 DBCollection  tb = db.getCollection("Applicationdetails");
		 BasicDBObject query = new BasicDBObject();
		 query.put("status_id","2");
		 query.put("tester_id",returnString);
		 DBCursor cursor = tb.find(query);
		 
		 try {
			   while(cursor.hasNext()) {
			      returnString= cursor.next().toString();
			     System.out.println(returnString);
			     res = res.append(returnString).append(comma);
			     
			   }
			  res.setLength(res.length() - 1);
			   String result= fbracket+res+lbracket;
			   res2 = result.toString();
			   System.out.println(res2);  
			   
			} finally {
			   cursor.close();
			}
		
      
    }catch(Exception e){
    	e.printStackTrace();
    	return Response.status(500).entity("Server cannot able to process request").build();
    	
    }
   // System.out.println(Response.ok(returnString).build());
     return Response.ok(res2).build(); 
	}

	@Path("/addtest")
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_JSON})
	
	@Produces(MediaType.APPLICATION_JSON)
	public Response addTest(String indata)throws Exception{
		 // To connect to mongodb server
		System.out.println("Inside Post function");
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			int Appid=0;
         // Now connect to your databases
         @SuppressWarnings({ "deprecation" })
		DB db = mongoClient.getDB( "local" );
         System.out.println("Connect to database successfully");
        // mongoClient.setWriteConcern(WriteConcern.ACKNOWLEDGED);
		String returnString=null;
		JSONArray jsonArray=new JSONArray();
		int http_code=200;
		//Mongodb db=new Mongodb();
		
		
		
		try
	    {
	      System.out.println("incomingdata: " + indata);
			ObjectMapper mapper=new ObjectMapper();

			addTest addtest=mapper.readValue(indata,addTest.class);
			 DBCollection  tb = db.getCollection("Applicationdetails");
		
			 BasicDBObject query = new BasicDBObject();
			 DBCursor cursor = tb.find(query);
			 try {
				   while(cursor.hasNext()) {
				      returnString= (String) cursor.next().get("Appid");
				   }
				} finally {
				   cursor.close();
				}	 
			
			 Appid=Integer.parseInt(returnString);
			 Appid=Appid+1;
			 String Appids=String.valueOf(Appid);
			 System.out.println(Appid);
			BasicDBObject doc1 = new BasicDBObject("app_name",addtest.app_name).append("priority", addtest.priority).append("platform",addtest.platform).append("tester_Id",addtest.tester_id).append("status_id",addtest.status_id).append("description",addtest.description).append("username",addtest.username).append("Appid",Appids );
			
			tb.insert(doc1);
			DBCollection  tb2 = db.getCollection("resulttable");
			BasicDBObject doc2 = new BasicDBObject("app_name",addtest.app_name).append("priority", addtest.priority).append("platform",addtest.platform).append("status_id",addtest.status_id).append("username",addtest.username).append("Appid",Appids);
			tb2.insert(doc2);
			System.out.println("After insert");
			
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	return Response.status(500).entity("Server cannot able to process request").build();
	    	
	    }
		returnString="Success";
	     return Response.ok(returnString).build(); 
		      
		
		
		
		
	}
}

class Adduser
{
	
	public String user_type;
	public String email_id;
	public String user_name;
	public String password;
	public String first_name;
	public String last_name;
	public String gender;
	
	public String phone_number;
	
	
	}
class addTest{
	public String app_name;
	public String priority;
	public String platform;
	public String tester_id;
	public String status_id;
	public String description;
	public String username;
}
class addResult{
	public String app_id;
	public String lowbugs;
	public String mediumbugs;
	public String highbugs;
	public String highbugcost;
	public String lowbugcost;
	public String mediumbugcost;
}	      
class assigntester{
	public String app_id;
	public String tester_id;
	
	
}	 
class updateBilling{
	public String app_id;
	public String amount;
}
      
	     


	    



