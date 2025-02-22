package com.example.demo.Mapper;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.Entity.Employee;

public class EmployeeMapper {
    
    public static EmployeeDTO mapToEmployeeDTO(Employee employee) {
        if (employee == null) {
            return null; 
        }
        return new EmployeeDTO(
            employee.getId(),
            employee.getFullName(),
            employee.getPhone(),
            employee.getEmail()
        );
    }
    
    public static Employee mapToEmployee(EmployeeDTO employeeDTO) {
        if (employeeDTO == null) {
            return null; 
        }
        return new Employee(
        		employeeDTO.getId(),
        		employeeDTO.getFullName(),
        		employeeDTO.getPhone(),
        		employeeDTO.getEmail()
           
        );
    }
}

