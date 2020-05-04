package com.tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class loginbean {

	private String name;
    private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean save(){  
		int result = 0;  
		try{  
		Class.forName("com.mysql.jdbc.Driver");     
		Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/Emp","prashu","");  
		PreparedStatement stmt = con.prepareStatement("insert into user(name,password) values(?,?)");  
		stmt.setString(1, name);  
		stmt.setString(2, password);  
		result = stmt.executeUpdate();  
		}catch(Exception e){  
		System.out.println(e);  
		}  
		if(result == 1){  
		return true;  
		}else return false;  
		}  
		  
		public String submit(){  
		if(this.save()){  
		return "index_response.xhtml";  
		}else return "index.xhtml";  
		}     		
	
}
