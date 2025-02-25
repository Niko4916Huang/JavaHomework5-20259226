package service.impl;

import java.util.List;

import dao.impl.EmployeeDaoImpl;
import model.Employee;
import service.EmployeeService;
 
public class EmployeeServiceImpl implements  EmployeeService
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*
		// new add
		Employee employee = new Employee("A004", "Weley", "weley", "1234");
		new EmployeeDaoImpl().add(employee);
	*/	
		
	/*
		// login
		// System.out.println(new EmployeeServiceImpl().Login("lin","ccc"));
			// result: null
		// System.out.println(new EmployeeServiceImpl().Login("admin","admin"));
		// result: model.Employee@d4342c2
	*/
	
	/*
		// find
		System.out.println(new EmployeeServiceImpl().isUsernameBeenUse("admin"));
		// result: true
	 
	*/

	}
	
	private static EmployeeDaoImpl employeedaoimpl=new EmployeeDaoImpl();

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeedaoimpl.add(employee);
	}

	@Override
	public Employee Login(String username, String password) {
		// TODO Auto-generated method stub
		Employee employee = null;
		List<Employee> listemployee = employeedaoimpl.selectUsernameAndPassword(username, password);
		if(listemployee.size()!=0)
		{
			employee=listemployee.get(0);
		}
		
		return employee;
	}

	@Override
	public boolean isUsernameBeenUse(String username) {
		// TODO Auto-generated method stub
		return !employeedaoimpl.selectByUsername(username).isEmpty();
	}

	@Override
	public boolean isEmployeenoBeenUse(String employeeno) {
		// TODO Auto-generated method stub
		return !employeedaoimpl.selectByUEmployeeno(employeeno).isEmpty();
	}
	

	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return employeedaoimpl.selectAll();
	}


	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeedaoimpl.update(employee);
	}

	@Override
	public void deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		employeedaoimpl.delete(id);
		
	}

	@Override
	public Employee findByEmployeeno(String employeeno) {
		// TODO Auto-generated method stub
		
		Employee employee = null;
		
		List<Employee> listEmployee = employeedaoimpl.selectByUEmployeeno(employeeno);
		if (listEmployee.size() > 0)
		{
			employee = listEmployee.get(0);
		}
		
		return employee;
		 
	}
	
	

}
