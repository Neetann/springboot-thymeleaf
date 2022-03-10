package net.java.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.java.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
