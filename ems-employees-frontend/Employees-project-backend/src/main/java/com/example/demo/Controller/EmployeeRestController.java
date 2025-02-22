package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.Service.EmployeeService;


import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
@CrossOrigin("*")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDTO> createEmployee (@RequestBody EmployeeDTO employeeDTO)
	{
		EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
		return ResponseEntity.ok(savedEmployee);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees()
	{
		List<EmployeeDTO> employees = employeeService.getAllEmployee();
		return ResponseEntity.ok(employees);
	}
	
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId)
	{
		EmployeeDTO employee= employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("/{employeeId}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long employeeId , @RequestBody EmployeeDTO employeeDTO)
	{
		EmployeeDTO updated = employeeService.updateEmployee(employeeId, employeeDTO);
		return ResponseEntity.ok(updated);
		
	}
	
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId)
	{
		employeeService.deleteEmployeeById(employeeId);
		return ResponseEntity.ok("Employee deleted!");
		
	}
	
	
	
	

	
}
