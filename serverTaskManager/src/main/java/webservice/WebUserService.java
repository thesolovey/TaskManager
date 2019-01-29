package webservice;

import bootstrap.Bootstrap;
import entity.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class WebUserService {

    private final Bootstrap bootstrap = new Bootstrap();

    @WebMethod
    public void createUser(User user) {
        bootstrap.getUserService().addUserByList(user);
    }

    @WebMethod
    public void authorizationUser(User user) {
        bootstrap.getUserService().setCurrentUser(user);
    }

    @WebMethod
    public void logoutUser(User user) {
        bootstrap.getUserService().logOut();
    }

    @WebMethod
    public User currentUser() {
        User user = bootstrap.getUserService().getCurrentUser();
        return user;
    }

    @WebMethod
    public void setCurrentUser(User currentUser) {
        bootstrap.getUserService().setCurrentUser(currentUser);
    }

    @WebMethod
    public List<User> findAll() {
        final List<User> userList = bootstrap.getUserService().getUsersList();
        return userList;
    }

    @WebMethod
    public boolean auth() {
        if (bootstrap.getUserService().isAuth()); return true;
    }
}
