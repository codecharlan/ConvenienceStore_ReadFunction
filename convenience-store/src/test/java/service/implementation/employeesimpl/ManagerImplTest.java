package service.implementation.employeesimpl;

import com.codecharlan.conveniencestore.enums.Gender;
import com.codecharlan.conveniencestore.enums.Role;
import com.codecharlan.conveniencestore.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ManagerImplTest {
    Employee employee;
    ManagerImpl manager;
    Role role;
    @BeforeEach
    void setUp() {
        employee = new Employee("Ernest", Gender.MALE,"No 12, danny way","A3452672","03/06/2020",Role.MANAGER,200890.83);
        manager = new ManagerImpl("Fred", Gender.MALE, "No 12, danny way", "A3452671", "09/11/2024", Role.MANAGER, 568676.66);

    }

    @Test
    void hireCashier() {
        String expected = employee + " has been hired on " + employee.getHireDate();
        String actual = manager.hireCashier(employee, Role.MANAGER);
        Assertions.assertEquals(expected, actual);
        Assertions.assertNotNull(actual);
    }

    @Test
    void fireCashier() {
        String expected = employee.getName() + " with ID" + employee.getEmployeeID() + " has been fired";
        String actual = manager.fireCashier(employee);
        Assertions.assertEquals(expected, actual);
        Assertions.assertNotNull(actual);
    }
}