package endpoint;

import entity.User;
import webservice.WebUserService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService
public class EndPointUser {
    WebUserService webUserService = new WebUserService();

    @WebMethod
    public void run() {

        Endpoint.publish("http://localhost:8080/user?wsdl", new WebUserService());

    }

    @WebMethod
    public void create(User newUser) {

    }

    @WebMethod
    public void delete() {

    }

    @WebMethod
    public User getCurrentUser() {
        User user = webUserService.currentUser();
        return user;
    }

    @WebMethod
    public void setCurrentUser(User currentUser) {
        webUserService.setCurrentUser(currentUser);
    }

    @WebMethod
    public List<User> findAll() {
        List<User> userList = webUserService.findAll();
        return userList;
    }

    @WebMethod
    public boolean auth() {
        if (webUserService.auth()); return true;
    }
}
