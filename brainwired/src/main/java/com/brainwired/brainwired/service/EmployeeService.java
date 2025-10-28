package com.brainwired.brainwired.service;

import com.brainwired.brainwired.dto.EmployeeDto;
import com.brainwired.brainwired.exception.EmployeeNotFoundException;
import com.brainwired.brainwired.model.Employee;
import com.brainwired.brainwired.repository.EmployeeRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException("Employee not exist"));
    }

    public Employee addEmployee(@Valid EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());
        return employeeRepository.save(employee);
    }

    public Employee update(EmployeeDto dto, Long id) {
        Employee employ = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

        employ.setName(dto.getName());
        employ.setEmail(dto.getEmail());
        employ.setDepartment(dto.getDepartment());
        employ.setSalary(dto.getSalary());

        return employeeRepository.save(employ);
    }

    public void delete(Long id) {
        Employee employee=employeeRepository.getEmployeeById(id);
        employeeRepository.deleteById(id);
    }
}
