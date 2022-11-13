package com.boomi.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="filedata")
public class FileData {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String account;
	private String due_date;
	private String p_id;
	private String category;
	private String name;
	private long quantity;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumns({
	@JoinColumn(nullable = false),
	@JoinColumn(nullable = false)
	})
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Employee employee;

	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public FileData(long id, String account, String due_date, String p_id, String category, String name,
			long quantity) {
		super();
		this.id = id;
		this.account = account;
		this.due_date = due_date;
		this.p_id = p_id;
		this.category = category;
		this.name = name;
		this.quantity = quantity;
	}
	public FileData() {
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
}
