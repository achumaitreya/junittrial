package com.hibernate.locking.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.hibernate.locking.model.Employee;
import com.hibernate.locking.service.EmployeeService;
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
@Autowired
MockMvc mockMvc;
@MockBean
Employee employee;
@MockBean
EmployeeService employeeService;
	Employee e =new Employee("du","ji","ece",300);
	@Test
	void testGetEmployee() throws Exception {
		Mockito.when(employeeService.getEmployee(1)).thenReturn(e);
		mockMvc.perform(MockMvcRequestBuilders.get("/employee/1").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andExpect(jsonPath("$.name", is("du")));
	}

}
