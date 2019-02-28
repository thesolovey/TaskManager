package com.gmail.sdima.endpoint;

import com.gmail.sdima.entity.Session;
import com.gmail.sdima.entity.User;
import com.gmail.sdima.exception.AccessForbiddenException;
import com.gmail.sdima.service.SessionService;
import com.gmail.sdima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
@Component
public class EndpointUser {

    @Autowired private UserService userService;
    @Autowired private SessionService sessionService;

    @WebMethod
    public void createUser(@WebParam(name = "user") final User user) {
        userService.addUserByList(user); }

    @WebMethod
    public List<User> getUserList(@WebParam(name = "session") final Session session) throws AccessForbiddenException {
        sessionService.validateSession(session);
        return userService.getUsersList();
    }

    @WebMethod
    public List<User> getUserListForRegistration() { return userService.getUsersList(); }

    @WebMethod
    public User getUserById(@WebParam(name = "session") final Session session,
                            @WebParam(name = "userId") final String userId) throws AccessForbiddenException {
        sessionService.validateSession(session);
        return userService.getUserById(userId); }
}
