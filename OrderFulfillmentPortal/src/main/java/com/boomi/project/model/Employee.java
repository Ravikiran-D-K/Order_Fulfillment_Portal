package com.boomi.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.boomi.project.model.Employee;

@IdClass(EmployeePK.class)
@Entity
@Table(name = "employees")
public class Employee{
	
	@Column(name = "name")
	private String Name;

	@Id
	@Column(name="email", unique=true,nullable = false)
	private String Email;
	
	@Id
	@Column(name="password", unique=true,nullable = false)
	private String Password;
	
	public Employee() {
		
	}
	public Employee(String email, String password) {
		super();
		this.Email = email;
		this.Password = password;
	}


	public Employee(String name, String email, String password) {
		super();
		this.Name = name;
		this.Email = email;
		this.Password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}
	
}
