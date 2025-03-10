package com.amaris.devTest.model;

import java.util.List;

public class EmployeesResponse extends GenericApiResponse {

    private List<Employee> data;

    public List<Employee> getData() {
        return data;
    }
}
