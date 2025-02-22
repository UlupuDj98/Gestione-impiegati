package com.example.demo.Service;

import java.util.List;


import com.example.demo.DTO.EmployeeDTO;



public interface EmployeeService {
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
	public List<EmployeeDTO> getAllEmployee();
	public EmployeeDTO getEmployeeById(Long employeeId);
	public EmployeeDTO updateEmployee(Long employeeId , EmployeeDTO employeeDTO);
	public void deleteEmployeeById(Long employeeId);
	

}
