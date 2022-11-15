package com.boomi.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boomi.project.model.Employee;
import com.boomi.project.model.EmployeePK;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, EmployeePK>{

	@Query("SELECT t FROM Employee t WHERE t.Email=?1 or t.Password=?2")
	public List<Employee> findAll (String email,String password);

	@Query("SELECT t FROM Employee t WHERE t.Email=?1 and t.Password=?2")
	public Employee getEmp(String email, String password);
}
