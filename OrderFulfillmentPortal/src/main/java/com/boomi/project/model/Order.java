package com.boomi.project.model;

import java.util.List;

public class Order {

	private List<FileData> list;
	private List<String> email;
	public List<FileData> getList() {
		return list;
	}
	public void setList(List<FileData> list) {
		this.list = list;
	}
	public List<String> getEmail() {
		return email;
	}
	public void setEmail(List<String> email) {
		this.email = email;
	}
	public Order(List<FileData> list, List<String> email) {
		super();
		this.list = list;
		this.email = email;
	}
}
