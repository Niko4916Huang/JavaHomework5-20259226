package model;

import java.io.Serializable;

public class Employee   implements Serializable {
	Integer id;
	String employeeno;
	String name;
	String username;
	String password;
	
	public Employee(String employno, String name, String username, String password) {
		super();
		this.employeeno = employno;
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public Employee() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployeeno() {
		return employeeno;
	}

	public void setEmployeeno(String employeeno) {
		this.employeeno = employeeno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
