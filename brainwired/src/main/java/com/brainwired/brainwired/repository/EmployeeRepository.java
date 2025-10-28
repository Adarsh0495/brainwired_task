package com.brainwired.brainwired.repository;

import com.brainwired.brainwired.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee getEmployeeById(Long id);
}
