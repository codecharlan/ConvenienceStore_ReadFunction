package service;

import com.codecharlan.conveniencestore.enums.Role;
import com.codecharlan.conveniencestore.model.Employee;

public interface AuthoriseService {
        String cashierPassword = "B2345671";
        String managerPassword = "A3456782";


        String signIn(Employee employee, Role role, String password);

        String signOut(Employee employee);

}
