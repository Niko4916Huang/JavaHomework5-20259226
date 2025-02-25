package dao.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EmployeeDao;
import model.Employee;
import util.DbConnection;

public class EmployeeDaoImpl implements EmployeeDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*
		// add employee
		Employee employee = new Employee("A004", "Weley", "weley", "qaz");
		new EmployeeDaoImpl().add(employee);
	*/
	/*
		//list all employee		
		List<Employee> l=new EmployeeDaoImpl().selectAll();
		for(Employee s:l)
		{
			System.out.println(s.getId()+"\t"+s.getEmployno()+"\t"+s.getName()+"\t"+s.getUsername()+"\t"+s.getPassword());
		}
	*/
	/*	
		// find employee by username and password			
		System.out.println(new EmployeeDaoImpl().selectUsernameAndPassword("weley", "qaz"));
	*/
	/*
		// find employee by id
		System.out.println(new EmployeeDaoImpl().selectById(1));
	*/
	/*
		// find employee by username
		System.out.println(new EmployeeDaoImpl().selectByUsername("peter"));
	*/
	/*
		// update name
		List<Employee> listEmployee=new EmployeeDaoImpl().selectById(5);
		Employee oneEmployee=listEmployee.get(0);
		oneEmployee.setName("Ivy");
		oneEmployee.setUsername("ivy");
		
		new EmployeeDaoImpl().update(oneEmployee);
	*/	
		
	}	
	
// connect mysql database
	private static Connection conn= DbConnection.getDb();
	

	@Override
	public void add(Employee employee) {
		// TODO Auto-generated method stub
		String sql="insert into employee(employeeno, name, username, password) "
				+ "values(?,?,?,?)";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1,employee.getEmployeeno());
			preparedstatement.setString(2,employee.getName());
			preparedstatement.setString(3,employee.getUsername());
			preparedstatement.setString(4,employee.getPassword());
			

			preparedstatement.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	@Override
	public List<Employee> selectAll() {
		// TODO Auto-generated method stub
		String SQL="select * from employee";
		List<Employee> allEmployee = new ArrayList();
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(SQL);
			ResultSet resultset=preparedstatement.executeQuery();
			
			while(resultset.next())
			{
				Employee oneEmploy=new Employee();
				oneEmploy.setId(resultset.getInt("id"));
				oneEmploy.setEmployeeno(resultset.getString("employeeno"));
				oneEmploy.setName(resultset.getString("name"));
				oneEmploy.setUsername(resultset.getString("username"));
				oneEmploy.setPassword(resultset.getString("password"));
				
				allEmployee.add(oneEmploy);
				
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allEmployee;
	}

	@Override
	public List<Employee> selectUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		String sql = "select * from employee where username = ? and password = ?";
		List<Employee> oneEmployee = new ArrayList();
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1,username);
			preparedstatement.setString(2,password);
			ResultSet resultset=preparedstatement.executeQuery();
			
			while(resultset.next())
			{

				Employee oneEmploy=new Employee();
				oneEmploy.setId(resultset.getInt("id"));
				oneEmploy.setEmployeeno(resultset.getString("employeeno"));
				oneEmploy.setName(resultset.getString("name"));
				oneEmploy.setUsername(resultset.getString("username"));
				oneEmploy.setPassword(resultset.getString("password"));								
				
				oneEmployee.add(oneEmploy);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oneEmployee;
	}

	@Override
	public List<Employee> selectById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from employee where id = ?";
		List<Employee> oneEmployee = new ArrayList();
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1,id);
			ResultSet resultset=preparedstatement.executeQuery();
			
			while(resultset.next())
			{

				Employee oneEmploy=new Employee();
				oneEmploy.setId(resultset.getInt("id"));
				oneEmploy.setEmployeeno(resultset.getString("employeeno"));
				oneEmploy.setName(resultset.getString("name"));
				oneEmploy.setUsername(resultset.getString("username"));
				oneEmploy.setPassword(resultset.getString("password"));
				
				oneEmployee.add(oneEmploy);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oneEmployee;
	}

	@Override
	public List<Employee> selectByUsername(String username) {
		// TODO Auto-generated method stub
		String sql = "select * from employee where username = ?";
		List<Employee> oneEmployee = new ArrayList();
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1,username);
			ResultSet resultset=preparedstatement.executeQuery();
			
			while(resultset.next())
			{

				Employee oneEmploy=new Employee();
				oneEmploy.setId(resultset.getInt("id"));
				oneEmploy.setEmployeeno(resultset.getString("employeeno"));
				oneEmploy.setName(resultset.getString("name"));
				oneEmploy.setUsername(resultset.getString("username"));
				oneEmploy.setPassword(resultset.getString("password"));
				
				oneEmployee.add(oneEmploy);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oneEmployee;
	}
	

	@Override
	public List<Employee> selectByUEmployeeno(String employeeno) {
		// TODO Auto-generated method stub
		String sql = "select * from employee where employeeno = ?";
		List<Employee> oneEmployee = new ArrayList();
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1,employeeno);
			ResultSet resultset=preparedstatement.executeQuery();
			
			while(resultset.next())
			{

				Employee oneEmploy=new Employee();
				oneEmploy.setId(resultset.getInt("id"));
				oneEmploy.setEmployeeno(resultset.getString("employeeno"));
				oneEmploy.setName(resultset.getString("name"));
				oneEmploy.setUsername(resultset.getString("username"));
				oneEmploy.setPassword(resultset.getString("password"));
				
				oneEmployee.add(oneEmploy);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oneEmployee;
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		String sql="update employee set employeeno=?,name=?,username=?, password=? where id=?";
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1,employee.getEmployeeno());
			preparedstatement.setString(2,employee.getName());
			preparedstatement.setString(3,employee.getUsername());
			preparedstatement.setString(4,employee.getPassword());			
			preparedstatement.setInt(5,employee.getId());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from employee where id=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1,id);
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
