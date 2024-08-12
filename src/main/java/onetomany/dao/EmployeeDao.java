package onetomany.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import onetomany.dto.Employee;

public class EmployeeDao {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shubham");
		return entityManagerFactory.createEntityManager();
	}
	
	public void saveEmployee(Employee employee) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
	}
	
	public void updateEmployee(int id, Employee employee) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Employee receivedEmployee = entityManager.find(Employee.class, id);
		
		if(receivedEmployee != null) {
			employee.setId(id);
			
			entityTransaction.begin();			
			entityManager.merge(employee);
			entityTransaction.commit();
		}else {
			System.out.println("Employee is not from your company");
		}
	}
	
	public void deleteEmployee(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Employee receivedEmployee = entityManager.find(Employee.class, id);
		
		if(receivedEmployee != null) {
			entityTransaction.begin();			
			entityManager.remove(receivedEmployee);
			entityTransaction.commit();
		}else {
			System.out.println("This person is not employee of the company");
		}
	}
	
	public void getEmployee(int id) {
		EntityManager entityManager = getEntityManager();
		
		Employee employee = entityManager.find(Employee.class, id);
		System.out.println(employee);
	}
	
	public void getAllEmployee() {
		EntityManager entityManager = getEntityManager();
		
		Query query = entityManager.createQuery("SELECT e FROM Employee e");
		
		List<Employee> list = query.getResultList();
		
		for(Employee employee : list) {
			System.out.println(employee);
		}
	}
}
