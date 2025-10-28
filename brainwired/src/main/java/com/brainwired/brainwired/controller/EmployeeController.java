package com.brainwired.brainwired.controller;

import com.brainwired.brainwired.dto.EmployeeDto;
import com.brainwired.brainwired.model.Employee;
import com.brainwired.brainwired.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>>getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee>getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody EmployeeDto dto) {
        Employee savedEmployee = employeeService.addEmployee(dto);
        return ResponseEntity.ok(savedEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @Valid @RequestBody EmployeeDto employeeDTO,
            @PathVariable Long id) {
        Employee updatedEmployee = employeeService.update(employeeDTO, id);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }

}
