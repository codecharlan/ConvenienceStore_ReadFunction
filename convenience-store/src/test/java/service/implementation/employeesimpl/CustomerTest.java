package service.implementation.employeesimpl;

import com.codecharlan.conveniencestore.enums.Gender;
import com.codecharlan.conveniencestore.model.Customer;
import com.codecharlan.conveniencestore.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer customer;
    Product product;

    @BeforeEach
    void setUp() {
        customer = new Customer("Mimie", Gender.FEMALE, "23, Ajason rd", 2341.567);
        product = new Product("Milk", 3.45, "9", "beverage");

    }

    @Test
    void selectProduct() {
        String expected = customer.getName() + " has selected this "
                + product;
        String actual = customer.selectProduct(customer, product);
        Assertions.assertEquals(expected,actual);
        Assertions.assertNotNull(actual);
    }

    @Test
    void makePayment() {
        String expected = customer.getName() + " Your Payment of $" + product.getProductPrice()
                + " for " + product.getProductName() + " is Successful";
        String actual = customer.makePayment(customer, product);
        Assertions.assertEquals(expected, actual);
        Assertions.assertNotNull(actual);
        Assertions.assertTrue(true, String.valueOf(customer.getMoneyInWallet() >= product.getProductPrice()));
    }
}