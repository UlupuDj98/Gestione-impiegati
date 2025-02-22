package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;




@Builder
@Entity
@Table(name="employees")
public class Employee{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="full_name" , nullable= false)
	private String fullName;
	@Column(name="telefon", unique=true , nullable=false)
	private String phone;
	@Column(name="mail" , unique = true , nullable=false)
	private String email;
	
	
	public Long getId() {
		return id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Employee(Long id, String fullName, String phone, String email) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
	}
	public Employee() {
		super();
	}
	
	
	
	
	
	
	

	
}
