package com.amaris.devTest.repository;

import com.amaris.devTest.model.Employee;

import com.amaris.devTest.model.EmployeeResponse;
import com.amaris.devTest.model.EmployeesResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Repository
public class EmployeeRepository {

    private final RestTemplate restTemplate;
    private static final String BASE_URL = "http://dummy.restapiexample.com/api/v1";

    HttpHeaders headers = createHeaders();
    HttpEntity<String> entity = new HttpEntity<>(headers);

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cookie", "humans_21909=1");
        return headers;
    }

    public EmployeeRepository() {
        this.restTemplate = new RestTemplate();
    }

    public List<Employee> GetAllEmployees() {
        try {
            ResponseEntity<EmployeesResponse> response = restTemplate.exchange(BASE_URL+"/employees", HttpMethod.GET, entity, EmployeesResponse.class);
            if(response.getStatusCode() == HttpStatus.OK && response.getBody().getData() != null) {
                return response.getBody().getData();
            } else {
                return Collections.emptyList();
            }
        } catch (HttpClientErrorException e) {
            return Collections.emptyList();
        }
    }

    public Employee getEmployeeByID(int id) {
        try {
            ResponseEntity<EmployeeResponse> response = restTemplate.exchange(BASE_URL+"/employee/"+id, HttpMethod.GET, entity, EmployeeResponse.class);
            if(response.getStatusCode() == HttpStatus.OK && response.getBody().getData() != null) {
                return response.getBody().getData();
            } else {
                return null;
            }
        } catch (HttpClientErrorException e) {
            System.out.println(e);
            return null;
        }
    }

}
