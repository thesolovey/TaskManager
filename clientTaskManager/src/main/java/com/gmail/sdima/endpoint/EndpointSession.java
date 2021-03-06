package com.gmail.sdima.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-03-01T18:04:43.652+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint.sdima.gmail.com/", name = "EndpointSession")
@XmlSeeAlso({ObjectFactory.class})
public interface EndpointSession {

    @WebMethod
    @Action(input = "http://endpoint.sdima.gmail.com/EndpointSession/getNewSessionRequest", output = "http://endpoint.sdima.gmail.com/EndpointSession/getNewSessionResponse")
    @RequestWrapper(localName = "getNewSession", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.GetNewSession")
    @ResponseWrapper(localName = "getNewSessionResponse", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.GetNewSessionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.gmail.sdima.endpoint.Session getNewSession(
        @WebParam(name = "userId", targetNamespace = "")
        java.lang.String userId
    );

    @WebMethod
    @Action(input = "http://endpoint.sdima.gmail.com/EndpointSession/validateSessionRequest", output = "http://endpoint.sdima.gmail.com/EndpointSession/validateSessionResponse", fault = {@FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.sdima.gmail.com/EndpointSession/validateSession/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "validateSession", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.ValidateSession")
    @ResponseWrapper(localName = "validateSessionResponse", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.ValidateSessionResponse")
    public void validateSession(
        @WebParam(name = "session", targetNamespace = "")
        com.gmail.sdima.endpoint.Session session
    ) throws AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.sdima.gmail.com/EndpointSession/getSessionByUserIdRequest", output = "http://endpoint.sdima.gmail.com/EndpointSession/getSessionByUserIdResponse")
    @RequestWrapper(localName = "getSessionByUserId", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.GetSessionByUserId")
    @ResponseWrapper(localName = "getSessionByUserIdResponse", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.GetSessionByUserIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.gmail.sdima.endpoint.Session getSessionByUserId(
        @WebParam(name = "userId", targetNamespace = "")
        java.lang.String userId
    );

    @WebMethod
    @Action(input = "http://endpoint.sdima.gmail.com/EndpointSession/logOutRequest", output = "http://endpoint.sdima.gmail.com/EndpointSession/logOutResponse")
    @RequestWrapper(localName = "logOut", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.LogOut")
    @ResponseWrapper(localName = "logOutResponse", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.LogOutResponse")
    public void logOut(
        @WebParam(name = "session", targetNamespace = "")
        com.gmail.sdima.endpoint.Session session
    );
}
