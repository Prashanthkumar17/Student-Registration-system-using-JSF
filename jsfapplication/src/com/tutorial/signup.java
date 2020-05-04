package com.tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class signup {
	private String firstname;
	private String lastname;
	private String email;
	private String age;
	private String password;
	private String country;
	
	//list of countries for the drop-down list
	List<String> countryOptions;
	
	//create no-arg constructor
public signup() {
		//populate the list of countries
	    countryOptions = new ArrayList<>();
	    
	    countryOptions.add("Brazil");
	    countryOptions.add("France");
	    countryOptions.add("India");
	    countryOptions.add("Germany"); 
	    
	}

//getter/setter methods

//need to add getter methods for country options

public List<String> getCountryOptions() {
	return countryOptions;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}


public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getAge() {
	return age;
}

public void setAge(String age) {
	this.age = age;
}


public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}
public boolean save(){  
	int result = 0;  
	try{  
	Class.forName("com.mysql.jdbc.Driver");     
	Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/Emp","prashu","");  
	PreparedStatement stmt = con.prepareStatement("insert into user(first name,last name,Email id, age, Password, country) values(?,?)");  
	stmt.setString(1, firstname);  
	stmt.setString(2, lastname);
            stmt.setString(3, email );
            stmt.setString(4,  age);
            stmt.setString(5, password);
            stmt.setString(2, country);
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
	return "signup_response.xhtml";  
	}else return "signup.xhtml";  
	}     	


}
