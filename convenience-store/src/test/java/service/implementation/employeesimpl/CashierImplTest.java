package service.implementation.employeesimpl;

import com.codecharlan.conveniencestore.enums.Gender;
import com.codecharlan.conveniencestore.enums.Role;
import com.codecharlan.conveniencestore.model.Customer;
import com.codecharlan.conveniencestore.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CashierImplTest {
    CashierImpl cashier;
    Product product;
    List<Product> products;
    Customer customer;

    @BeforeEach
    void setUp() {
        cashier = new CashierImpl("Laura", Gender.FEMALE, "No 56, crane road", "A3452672", "03/06/2020", Role.CASHIER, 200890.83);
        product = new Product("Milk", 3.45, "9", "beverage");
        customer = new Customer("Mimie", Gender.FEMALE, "23, Ajason rd", 2341.567);
        products = new ArrayList<>();

    }

    @Test
    void scanProduct() {
        String expected = "The price is of " + product.getProductName()
                + " is $"+ product.getProductPrice();
        String actual = cashier.scanProduct(product);
        Assertions.assertEquals(expected,actual);
    }


    @Test
    void printReceipt() {
        String expected = "Payment successful!!!, The receipt of " +
                "$"+ product.getProductPrice()+ " for "+
                product.getProductName() + " is being printed for " + customer.getName();
        String actual = cashier.printReceipt(customer, product);
        Assertions.assertEquals(expected,actual);
    }
}