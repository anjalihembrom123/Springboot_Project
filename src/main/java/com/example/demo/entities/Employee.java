package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private long id;
	private String name;
	private String email;
	private String address;
	private long dept_id;
	public Employee(long id, String name, String email,String address, long dept_id) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.dept_id = dept_id;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) { this.id = id; }

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public long getDept_id() {
		return dept_id;
	}
	public void setDept_id(long dept_id) {
		this.dept_id = dept_id;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", dept_id=" + dept_id + "]";
	}

}
