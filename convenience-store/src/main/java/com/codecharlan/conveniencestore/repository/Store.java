package com.codecharlan.conveniencestore.repository;

import com.codecharlan.conveniencestore.model.Customer;
import com.codecharlan.conveniencestore.model.Employee;
import com.codecharlan.conveniencestore.model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Store {
    private final String storeName;
    private List<Employee> employees;
    private List<Customer> customers;
    private List<Product> products;
    private List<String> categories;

    public Store(String storeName, List<Product> products, List<String> categories) {
        this.storeName = storeName;
        this.products = products;
        this.categories = categories;
    }

    public String getStoreName() {
        return storeName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public static List<Product> loadProductList(String filePath) {
        List<Product> products = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String productName = data[0];
                String productCategory = data[1];
                String productQuantity = data[2];
                double productPrice = Double.parseDouble(data[3]);

                Product product;
                if (productQuantity.equals(0)) {
                    product = new Product(productName, productPrice, productQuantity, productCategory);
                } else {
                    product = new Product(productName, productPrice, "OUT OF STOCK", productCategory);
                }

                products.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return products;
    }

    public List<String> getCategory(List<Product> products) {
        List<String> categories = new ArrayList<>();
        for (Product product : products) {
            if (!categories.contains(product.getProductCategory())) {
                categories.add(product.getProductCategory());
            }
        }
        return categories;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeName='" + storeName + '\'' +
                ", employees=" + employees +
                ", products=" + products +
                ", customers=" + customers +
                ", category=" + categories +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store store)) return false;
        return Objects.equals(getStoreName(), store.getStoreName()) && Objects.equals(getEmployees(), store.getEmployees()) && Objects.equals(getCustomers(), store.getCustomers()) && Objects.equals(getProducts(), store.getProducts()) && Objects.equals(getCategories(), store.getCategories());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStoreName(), getEmployees(), getCustomers(), getProducts(), getCategories());
    }
}
