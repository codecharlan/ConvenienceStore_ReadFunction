package com.codecharlan.conveniencestore;

import com.codecharlan.conveniencestore.enums.Gender;
import com.codecharlan.conveniencestore.enums.Role;
import com.codecharlan.conveniencestore.model.*;
import com.codecharlan.conveniencestore.repository.Store;
import service.implementation.AuthoriseServiceCashierImpl;
import service.implementation.AuthoriseServiceManagerImpl;
import service.implementation.employeesimpl.CashierImpl;
import service.implementation.employeesimpl.ManagerImpl;
import service.implementation.ProductCatalogServiceManagerImpl;

import java.util.ArrayList;
import java.util.List;

public class ConvenienceStoreApplication {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        List<String> categories = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        Store store = new Store("myStore", products, categories);
        ManagerImpl manager = new ManagerImpl("Fred", Gender.MALE, "No 12, danny way", "A3452671", "09/11/2024", Role.MANAGER, 568676.66);
        Employee employee = new Employee("Charlotte", Gender.MALE, "No 12, danny way", "A3452672", "03/06/2020", Role.MANAGER, 200890.83);
        CashierImpl cashier = new CashierImpl("Laura", Gender.FEMALE, "No 56, crane road", "A3452672", "03/06/2020", Role.CASHIER, 200890.83);
        Product product = new Product("Milk", 3.45, "9", "beverage");
        Customer customer = new Customer("Mimie", Gender.FEMALE, "23, Ajason rd", 2341.567);
        AuthoriseServiceManagerImpl managerimpl = new AuthoriseServiceManagerImpl();
        AuthoriseServiceCashierImpl cashierimpl = new AuthoriseServiceCashierImpl();
        ProductCatalogServiceManagerImpl productimpl = new ProductCatalogServiceManagerImpl();



        System.out.println(managerimpl.signIn(manager,  Role.MANAGER, "A3456782"));
        System.out.println(managerimpl.signOut(manager));
        System.out.println(manager.hireCashier(employee, Role.MANAGER));
        System.out.println(manager.fireCashier(employee));

        System.out.println("...............");
        System.out.println("...............");
//
        System.out.println(cashierimpl.signIn(cashier,  Role.CASHIER, "S223346"));
        System.out.println(cashierimpl.signOut(cashier));
        System.out.println(cashier.printReceipt(customer, product));
        System.out.println(cashier.scanProduct(product));
//
        System.out.println("...............");
        System.out.println("...............");

        customer.setMoneyInWallet(10000.004);
        System.out.println(customer.selectProduct(customer, product));
        System.out.println(customer.makePayment(customer, product));

        System.out.println("...............");
        System.out.println("...............");


        System.out.println(productimpl.restockProduct("convenience-store/src/main/resources/product.csv")); // read product list
        System.out.println("...............");
        System.out.println("...............");
        System.out.println(productimpl.getCategory(products));
        System.out.println("...............");
        System.out.println("...............");
        System.out.println(productimpl.updatePrice(product, 45));
        System.out.println("...............");
        System.out.println("...............");
        System.out.println(productimpl.discountPrice(product,10.34));
        System.out.println("...............");
        System.out.println("...............");

        //Test cases Available in test folder
    }

}
