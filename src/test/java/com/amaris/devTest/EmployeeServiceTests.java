package com.amaris.devTest;

import com.amaris.devTest.model.Employee;
import com.amaris.devTest.repository.EmployeeRepository;
import com.amaris.devTest.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EmployeeServiceTests {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEmployeeByIdCalculatedAnnualSalary() {
        Employee mockEmployee = new Employee(1, "John Doe", 30000, 35, "");
        when(employeeRepository.getEmployeeByID(1)).thenReturn(mockEmployee);
        Employee employee = employeeService.getEmployeeById(1);
        assertEquals(30000 * 12, employee.getEmployeeAnnualSalary());
    }

    @Test
    void testGetAllEmployeesCalculatedAnnualSalary() {
        List<Employee> mockEmployees = Arrays.asList(
                new Employee(1, "John Doe", 30000, 30, ""),
                new Employee(2, "Jane Doe", 50000, 31, "")
                );
        when(employeeRepository.GetAllEmployees()).thenReturn(mockEmployees);
        List<Employee> employees = employeeService.getAllEmployees();
        assertEquals(30000 * 12, employees.get(0).getEmployeeAnnualSalary());
        assertEquals(50000 * 12, employees.get(1).getEmployeeAnnualSalary());
    }

}
