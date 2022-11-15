package com.boomi.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "filedetails")
public class Mfile {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "fname")
    private String Fname;
	
	@Column(name = "fpath")
    private String Fpath;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumns({
	@JoinColumn(nullable = false),
	@JoinColumn(nullable = false)
	})
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Employee employee;
	
	public Employee getEmlpoyee() {
		return employee;
	}
	public void setEmlpoyee(Employee employee) {
		this.employee = employee;
	}
	public Mfile(Long id, String fname, String fpath) {
		super();
		this.id = id;
		this.Fname = fname;
		this.Fpath = fpath;
	}
	public Mfile() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getFpath() {
		return Fpath;
	}
	public void setFpath(String fpath) {
		Fpath = fpath;
	}
    
}
