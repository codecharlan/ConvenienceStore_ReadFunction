package service.implementation;
import com.codecharlan.conveniencestore.enums.Role;
import com.codecharlan.conveniencestore.model.Employee;
import service.AuthoriseService;
import service.implementation.employeesimpl.ManagerImpl;

public class AuthoriseServiceManagerImpl implements AuthoriseService {
    @Override
    public String signIn(Employee employee, Role role, String password) {
        if(managerPassword != password || role != Role.MANAGER){
            return "Access denied! Sign in unsuccessful";
        }else {
            return "Welcome " + employee.getName()
                    + "!" + "\n" + "Signed in Successfully";
        }
//
    }

    @Override
    public String signOut(Employee employee) {
        return "GoodBye " + employee.getName()
                + "!" + "\n"+ "Signed out Successfully";
    }


}
