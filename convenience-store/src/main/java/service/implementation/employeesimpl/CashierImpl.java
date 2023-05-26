package service.implementation.employeesimpl;

import com.codecharlan.conveniencestore.enums.Gender;
import com.codecharlan.conveniencestore.enums.Role;
import com.codecharlan.conveniencestore.model.Customer;
import com.codecharlan.conveniencestore.model.Employee;
import com.codecharlan.conveniencestore.model.Product;

public class CashierImpl extends Employee {
    public CashierImpl(String name, Gender gender, String address, String employeeID, String hireDate, Role roles, Double salary) {
        super(name, gender, address, employeeID, hireDate, roles, salary);
    }
    public String scanProduct(Product product){
        return "The price is of " + product.getProductName()
                + " is $"+ product.getProductPrice();
    }
    public String printReceipt(Customer customer, Product product){
        return "Payment successful!!!, The receipt of " +
                "$"+ product.getProductPrice()+ " for "+
                product.getProductName() + " is being printed for " + customer.getName();
    }
}
