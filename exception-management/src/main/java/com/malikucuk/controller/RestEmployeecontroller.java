package com.malikucuk.controller;

import com.malikucuk.dto.DtoEmployee;
import com.malikucuk.dto.DtoEmployeeIU;

public interface RestEmployeecontroller {

	public DtoEmployee finDtoEmployeeById(Long id);
    public DtoEmployee createNewEmployee(DtoEmployeeIU dtoEmployeeIU);
	
}
