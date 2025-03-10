package com.amaris.devTest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

    private int id;
    @JsonProperty("employee_name")
    private String name;
    @JsonProperty("employee_salary")
    private int employeeSalary;
    private int employeeAnnualSalary;
    @JsonProperty("employee_age")
    private int employeeAge;
    @JsonProperty("profile_image")
    private String profileImage;

    public Employee(int id, String name, int salary, int age, String image) {
        this.id = id;
        this.name = name;
        this.employeeSalary = salary;
        this.employeeAge = age;
        this.profileImage = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public int getEmployeeAnnualSalary() {
        return employeeAnnualSalary;
    }

    public void setEmployeeAnnualSalary(int employeeAnnualSalary) {
        this.employeeAnnualSalary = employeeAnnualSalary;
    }
}
