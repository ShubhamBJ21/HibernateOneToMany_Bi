package onetomany.controller;

import java.util.ArrayList;
import java.util.List;

import onetomany.dao.EmployeeDao;
import onetomany.dto.Company;
import onetomany.dto.Employee;

public class EmployeeMain {
	public static void main(String[] args) {
		Company company = new Company();
		company.setCompanyName("SJ Company");
		company.setCompanyAddress("Mugaon");
		
		Employee emp1 = new Employee("Shubham Jadhav", 8830086429L, company);
		Employee emp2 = new Employee("Krishna Kadam", 9021453678L, company);
		Employee emp3 = new Employee("Vaibhav Nagare", 7083415269L, company);
		
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(emp1);
		employeeList.add(emp2);
		employeeList.add(emp3);
		company.setEmployees(employeeList);
		
		EmployeeDao dao = new EmployeeDao();
		dao.saveEmployee(emp1);
	}
}
