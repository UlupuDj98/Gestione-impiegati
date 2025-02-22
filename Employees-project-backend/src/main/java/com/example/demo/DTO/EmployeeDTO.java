package com.example.demo.DTO;




public class EmployeeDTO {
	Long id ; 
	String fullName ; 
	String phone ; 
	String email;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public EmployeeDTO(Long id, String fullName, String phone, String email) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
	}
	public EmployeeDTO() {
		super();
	}
	
	
	
	
	
}
