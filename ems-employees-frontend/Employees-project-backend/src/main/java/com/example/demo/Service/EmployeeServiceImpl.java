package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.Entity.Employee;
import com.example.demo.Mapper.EmployeeMapper;
import com.example.demo.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
		employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDTO(employee);
		
	}

	
	@Override
	public List<EmployeeDTO> getAllEmployee() {
	    List<Employee> employees = employeeRepository.findAll();
	    return employees.stream()
	                    .map(EmployeeMapper::mapToEmployeeDTO) // Usa il metodo di riferimento
	                    .collect(Collectors.toList()); // Corretto: usa Collectors.toList()
	}

	
	@Override
	public EmployeeDTO getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(()-> new RuntimeException("Non esiste impiegato con l ID: " + employeeId));
		return EmployeeMapper.mapToEmployeeDTO(employee);
	}

	@Override
	public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeDTO) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(()-> new RuntimeException("Non esiste impiegato con l ID: " + employeeId));
		
		employee.setFullName(employeeDTO.getFullName());
		employee.setPhone(employeeDTO.getPhone());
		employee.setEmail(employeeDTO.getEmail());
		
		employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDTO(employee);
		
	}

	@Override
	public void deleteEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(()-> new RuntimeException("Non esiste impiegato con l ID: " + employeeId));
		
		employeeRepository.deleteById(employeeId);
		
	}

}
