package com.service.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.service.project.model.Employee;

@RestController
public class TestController {
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public Employee firstPage() {

		System.out.println("Inside firstPage");
		
		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);

		return emp;
	}
	
	public Employee getDataFallBack() {

		System.out.println("Inside fallback");
		
		Employee emp = new Employee();
		emp.setName("fallback-emp1");
		emp.setDesignation("fallback-manager");
		emp.setEmpId("fallback-1");
		emp.setSalary(3000);

		return emp;

	}
}
