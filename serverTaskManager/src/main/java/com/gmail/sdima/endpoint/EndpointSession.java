package com.gmail.sdima.endpoint;

import com.gmail.sdima.entity.Session;
import com.gmail.sdima.exception.AccessForbiddenException;
import com.gmail.sdima.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
@Component
public class EndpointSession {

    @Autowired private SessionService sessionService;

    @WebMethod
    public Session getNewSession(@WebParam(name = "userId") final String userId) { return sessionService.getNewSession(userId); }

    @WebMethod
    public void logOut(@WebParam(name = "session") final Session session) { sessionService.logOut(session); }

    @WebMethod
    public Session getSessionByUserId(@WebParam(name = "userId") final String userId) { return sessionService.getSessionById(userId); }

    @WebMethod
    public void validateSession(@WebParam(name = "session") final Session session) throws AccessForbiddenException { sessionService.validateSession(session); }
}
