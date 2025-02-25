package service;

import java.util.List;

import model.Employee;


public interface EmployeeService {
	
	//create
	void addEmployee(Employee employee);
	
	//read
	Employee Login(String username, String password);
	boolean isUsernameBeenUse(String username);
	boolean isEmployeenoBeenUse(String employeeno);
	List<Employee> findAllEmployee();
	Employee findByEmployeeno(String employeeno);
	
	//update
	void updateEmployee( Employee employee);
	
	//delete
	void deleteEmployeeById(int id);

}
