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
		
		Employee emp1 = new Employee();
		emp1.setName("Shubham Jadhav");
		emp1.setPhone(8830086429L);
		emp1.setCompany(company);
		
		Employee emp2 = new Employee();
		emp2.setName("Krishna Kadam");
		emp2.setPhone(9021453678L);
		emp2.setCompany(company);
		
		Employee emp3 = new Employee();
		emp3.setName("Vaibhav Nagare");
		emp3.setPhone(7083415269L);
		emp3.setCompany(company);
		
		List<Employee> list = new ArrayList<Employee>();
		
		list.add(emp1); list.add(emp2); list.add(emp3);
		
		company.setEmployees(list);
		
		EmployeeDao dao = new EmployeeDao();
		dao.saveEmployee(emp1);
	}
}
