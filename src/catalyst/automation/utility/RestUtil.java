package com.catalyst.qa.utils;

import java.sql.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestUtil {
	
	static Connection con=null;
	static 	String result="";
	public Response getAll(String WebServiceURL) {
		  RestAssured.baseURI = WebServiceURL;		 
		  Response response = null;
		  try {
		   response = RestAssured.given()
		    .when()
		    .get("/employees");
		  } catch (Exception e) {
		   e.printStackTrace();
		  }		 		 
		return response;
	}
	
	public Response create(String WebServiceURL,Object data) {
		  RestAssured.baseURI = WebServiceURL;		 
		  Response response = null;
		  try {
	            response = RestAssured.given()
	                .body(data)
	                .post("/employees");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }	 		 
		return response;
	}
	
	public static Connection databaseConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","password");  
		}catch(Exception e){ 
			System.out.println(e); 
		}
		return con; 
	}
	public static String readData() throws SQLException{
		try{
			con= databaseConnection();
			if(con!=null){
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from employee");  
				while(rs.next()){  
					String id = rs.getString("id");
					String name = rs.getString("name");
					int  sal = rs.getInt("sal");
					String Department= rs.getString("department");
					result+="ID: " + id + ", Name: " + name+ ", sal: " + sal + " Department : "+ Department;
				}
			}
			else{
				System.out.println("Database connecton not found..");
			}
			
		}catch(Exception e){ 
			System.out.println(e);  
		} 
		return result;
	}
}
