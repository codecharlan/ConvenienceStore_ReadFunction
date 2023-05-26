package com.codecharlan.conveniencestore.model;

import com.codecharlan.conveniencestore.enums.Gender;
import com.codecharlan.conveniencestore.enums.Role;

public class Employee extends People {
    private String employeeID;
    private String hireDate;
    private Role roles;
    private Double salary;

    public Employee(String name, Gender gender, String address, String employeeID, String hireDate, Role roles, Double salary) {
        super(name, gender, address);
        this.employeeID = employeeID;
        this.hireDate = hireDate;
        this.roles = roles;
        this.salary = salary;
    }


    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", roles=" + roles +
                ", salary=" + salary +
                "} " + super.toString();
    }
}
