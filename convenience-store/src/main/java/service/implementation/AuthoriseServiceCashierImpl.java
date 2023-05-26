package service.implementation;
import com.codecharlan.conveniencestore.enums.Role;
import com.codecharlan.conveniencestore.model.Employee;
import service.AuthoriseService;


public class AuthoriseServiceCashierImpl implements AuthoriseService {


    @Override
    public String signIn(Employee employee, Role role, String password) {
        if(cashierPassword != password || role != Role.CASHIER){
            return "Access Denied!, Sign in Unsuccessful";
        }else {
            return "Welcome " + employee.getName()
                    + "!" + "\n" + "Signed in Successfully";}
    }

    @Override
    public String signOut(Employee employee) {
        return "GoodBye " + employee.getName()
                + "!" + "\n"+ "Signed out Successfully";
    }

}
