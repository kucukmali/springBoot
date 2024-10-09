package com.malikucuk.service.Impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malikucuk.dto.DtoDepartment;
import com.malikucuk.dto.DtoEmployee;
import com.malikucuk.dto.DtoEmployeeIU;
import com.malikucuk.exception.BaseException;
import com.malikucuk.exception.ErrorMessage;
import com.malikucuk.exception.MessageType;
import com.malikucuk.model.Department;
import com.malikucuk.model.Employee;
import com.malikucuk.repository.EmployeeRepository;
import com.malikucuk.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public DtoEmployee findEmployeeById(Long id) {
		
		DtoEmployee dtoEmployee = new DtoEmployee();
		DtoDepartment dtoDepartment = new DtoDepartment();
		
		Optional<Employee> optional = employeeRepository.findById(id);
		if(optional.isEmpty())
		{
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
		}
		
		Employee employee = optional.get();
		Department department = employee.getDepartment();
		
		BeanUtils.copyProperties(employee, dtoEmployee);
		BeanUtils.copyProperties(department, dtoDepartment);
		
		dtoEmployee.setDepartment(dtoDepartment);
		
		return dtoEmployee;
	}
	

	@Override
	public DtoEmployee createNewEmployee(DtoEmployeeIU dtoEmployeeIU) {
	   
	    Employee employee = new Employee();
	    BeanUtils.copyProperties(dtoEmployeeIU, employee);

	   
	    if (dtoEmployeeIU.getDepartment() != null) {
	        Department department = new Department();
	        BeanUtils.copyProperties(dtoEmployeeIU.getDepartment(), department);
	        employee.setDepartment(department);
	    }

	  
	    Employee dbEmployee = employeeRepository.save(employee);

	    
	    DtoEmployee createRequest = new DtoEmployee();
	    BeanUtils.copyProperties(dbEmployee, createRequest);

	    return createRequest;
	}

}
