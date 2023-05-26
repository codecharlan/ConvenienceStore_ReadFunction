package com.codecharlan.conveniencestore.model;

import com.codecharlan.conveniencestore.enums.Gender;
import com.codecharlan.conveniencestore.repository.Store;

public class Customer extends People {
    private Double moneyInWallet;

    public Customer(String name, Gender gender, String address, Double moneyInWallet) {
        super(name, gender, address);
        this.moneyInWallet = moneyInWallet;
    }

    public Double getMoneyInWallet() {
        return moneyInWallet;
    }

    public void setMoneyInWallet(Double moneyInWallet) {
        this.moneyInWallet = moneyInWallet;
    }

    public String selectProduct(Customer customer, Product product) {
        return customer.getName() + " has selected this "
                + product;
    }

    public String makePayment(Customer customer, Product product) {
        if (moneyInWallet < product.getProductPrice()) {
            return customer.getName() + " You do not have sufficient balance in your " +
                    "wallet and cannot complete this payment";
        } else {
            return customer.getName() + " Your Payment of $" + product.getProductPrice()
                    + " for " + product.getProductName() + " is Successful";
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "accountBalance=" + moneyInWallet +
                "} " + super.toString();
    }
}
