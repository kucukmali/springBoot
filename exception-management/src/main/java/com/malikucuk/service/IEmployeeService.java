package com.malikucuk.service;

import com.malikucuk.dto.DtoEmployee;
import com.malikucuk.dto.DtoEmployeeIU;

public interface IEmployeeService {

	public  DtoEmployee findEmployeeById(Long id);
	public DtoEmployee createNewEmployee(DtoEmployeeIU dtoEmployeeIU);
	
	
}
