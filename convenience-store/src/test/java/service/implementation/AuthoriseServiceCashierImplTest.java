package service.implementation;

import com.codecharlan.conveniencestore.enums.Gender;
import com.codecharlan.conveniencestore.enums.Role;
import com.codecharlan.conveniencestore.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuthoriseServiceCashierImplTest {
    AuthoriseServiceCashierImpl cashierimpl;
    Employee employee;
    Role role;


    @BeforeEach
    void setUp() {
        cashierimpl = new AuthoriseServiceCashierImpl();
        employee = new Employee("Ernest", Gender.MALE,"No 12, danny way","A3452672","03/06/2020",Role.MANAGER,200890.83);

    }

    @Test
    void signIn() {
        String unexpected = "Access Denied!, Sign in Unsuccessful";
        String expected = "Welcome " + employee.getName()
                + "!" + "\n" + "Signed in Successfully";
        String actual = cashierimpl.signIn(employee,Role.CASHIER, "B2345671");
        Assertions.assertEquals(expected, actual);
        Assertions.assertNotEquals(unexpected,actual);
        Assertions.assertNotNull(actual);
    }

    @Test
    void signOut() {
        String expected = "GoodBye " + employee.getName()
                + "!" + "\n"+ "Signed out Successfully";
        String actual = cashierimpl.signOut(employee);
        Assertions.assertEquals(expected,actual);
        Assertions.assertNotNull(actual);
    }
}