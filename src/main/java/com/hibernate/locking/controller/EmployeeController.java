package com.hibernate.locking.controller;

import java.net.URI;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hibernate.locking.model.Employee;
import com.hibernate.locking.service.EmployeeService;


@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	Employee employee;
@RequestMapping(method=RequestMethod.POST,value="/employee")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) throws JsonMappingException, JsonProcessingException {
	employeeService.addEmployee(employee);
	String location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(employee.getId())
            .toUriString();
	  ObjectMapper mapper = new ObjectMapper();
      JsonNode json = mapper.readTree("{\"id\": \"132\", \"name\": \"Alice\"}");	
	return ResponseEntity.status(HttpStatus.CREATED).header(HttpHeaders.LOCATION, location).body(json);
	//return ResponseEntity.ok(json);
}
@RequestMapping(method=RequestMethod.PUT,value="/employee")
public void updateEmployee(@RequestBody Employee employee) {
employeeService.updateEmployee(employee);
}
@RequestMapping(method=RequestMethod.GET,value="/employee/{id}")
public Employee getEmployee(@PathVariable("id") Integer id) {
return employeeService.getEmployee(id);
}
}
