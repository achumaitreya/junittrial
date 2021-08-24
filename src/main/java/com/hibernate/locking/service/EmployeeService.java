package com.hibernate.locking.service;

import com.hibernate.locking.model.Employee;

public interface EmployeeService {
void addEmployee(Employee employee);
void updateEmployee(Employee employee);
Employee getEmployee(Integer id);
}
