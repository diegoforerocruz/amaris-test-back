package com.amaris.devTest.service;

import com.amaris.devTest.model.Employee;
import com.amaris.devTest.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private Employee annualSalary(Employee employee) {
        employee.setEmployeeAnnualSalary(employee.getEmployeeSalary() * 12);
        return employee;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.GetAllEmployees();
        return employees.stream().map(this::annualSalary).collect(Collectors.toList());
    }

    public Employee getEmployeeById(int id) {
        Employee employee = employeeRepository.getEmployeeByID(id);
        return employee == null? null: annualSalary(employee);
    }

}
