package service.implementation.employeesimpl;
import com.codecharlan.conveniencestore.enums.Gender;
import com.codecharlan.conveniencestore.enums.Role;
import com.codecharlan.conveniencestore.model.Employee;

import java.util.ArrayList;
import java.util.List;


public class ManagerImpl extends Employee{
    public ManagerImpl(String name, Gender gender, String address, String employeeID, String hireDate, Role roles, Double salary) {
        super(name, gender, address, employeeID, hireDate, roles, salary);
    }

    List<Employee> employees = new ArrayList<>();

    public String hireCashier(Employee employee, Role role){
        employee.setRoles(role);
        employees.add(employee);
        return employee + " has been hired on " + employee.getHireDate();
    }
    public String fireCashier(Employee employee){
        employees.remove(employee);
        return employee.getName() + " with ID" + employee.getEmployeeID() + " has been fired";
    }

}
