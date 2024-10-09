package com.malikucuk.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malikucuk.controller.RestEmployeecontroller;
import com.malikucuk.dto.DtoEmployee;
import com.malikucuk.dto.DtoEmployeeIU;
import com.malikucuk.service.IEmployeeService;

@RestController
@RequestMapping("rest/api/employee")
public class RestEmployeeControllerImpl implements RestEmployeecontroller{

	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping(path = "/list/{id}" )
	@Override
	public DtoEmployee finDtoEmployeeById(@PathVariable(value = "id") Long id) {
		// TODO Auto-generated method stub
		return employeeService.findEmployeeById(id);
	}
	

	@PostMapping(path = "/save")
	@Override
	public DtoEmployee createNewEmployee(@RequestBody DtoEmployeeIU dtoEmployeeIU) {
		return employeeService.createNewEmployee(dtoEmployeeIU); 
	}

}
 