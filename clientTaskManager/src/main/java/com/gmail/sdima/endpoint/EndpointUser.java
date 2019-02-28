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
 * 2019-02-28T11:25:45.589+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint.sdima.gmail.com/", name = "EndpointUser")
@XmlSeeAlso({ObjectFactory.class})
public interface EndpointUser {

    @WebMethod
    @Action(input = "http://endpoint.sdima.gmail.com/EndpointUser/createUserRequest", output = "http://endpoint.sdima.gmail.com/EndpointUser/createUserResponse")
    @RequestWrapper(localName = "createUser", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.CreateUser")
    @ResponseWrapper(localName = "createUserResponse", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.CreateUserResponse")
    public void createUser(
        @WebParam(name = "user", targetNamespace = "")
        com.gmail.sdima.endpoint.User user
    );

    @WebMethod
    @Action(input = "http://endpoint.sdima.gmail.com/EndpointUser/getUserListRequest", output = "http://endpoint.sdima.gmail.com/EndpointUser/getUserListResponse", fault = {@FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.sdima.gmail.com/EndpointUser/getUserList/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "getUserList", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.GetUserList")
    @ResponseWrapper(localName = "getUserListResponse", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.GetUserListResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.gmail.sdima.endpoint.User> getUserList(
        @WebParam(name = "session", targetNamespace = "")
        com.gmail.sdima.endpoint.Session session
    ) throws AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.sdima.gmail.com/EndpointUser/getUserByIdRequest", output = "http://endpoint.sdima.gmail.com/EndpointUser/getUserByIdResponse", fault = {@FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.sdima.gmail.com/EndpointUser/getUserById/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "getUserById", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.GetUserById")
    @ResponseWrapper(localName = "getUserByIdResponse", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.GetUserByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.gmail.sdima.endpoint.User getUserById(
        @WebParam(name = "session", targetNamespace = "")
        com.gmail.sdima.endpoint.Session session,
        @WebParam(name = "userId", targetNamespace = "")
        java.lang.String userId
    ) throws AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.sdima.gmail.com/EndpointUser/getUserListForRegistrationRequest", output = "http://endpoint.sdima.gmail.com/EndpointUser/getUserListForRegistrationResponse")
    @RequestWrapper(localName = "getUserListForRegistration", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.GetUserListForRegistration")
    @ResponseWrapper(localName = "getUserListForRegistrationResponse", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.GetUserListForRegistrationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.gmail.sdima.endpoint.User> getUserListForRegistration();
}
