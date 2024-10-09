package com.malikucuk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malikucuk.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public Employee findEmployeeById(Long id);

	public Employee save(Employee employee);
	
}
