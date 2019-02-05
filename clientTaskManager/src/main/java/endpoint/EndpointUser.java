package endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-02-05T16:45:42.537+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint/", name = "EndpointUser")
@XmlSeeAlso({ObjectFactory.class})
public interface EndpointUser {

    @WebMethod
    @Action(input = "http://endpoint/EndpointUser/getUserListForRegistrationRequest", output = "http://endpoint/EndpointUser/getUserListForRegistrationResponse")
    @RequestWrapper(localName = "getUserListForRegistration", targetNamespace = "http://endpoint/", className = "endpoint.GetUserListForRegistration")
    @ResponseWrapper(localName = "getUserListForRegistrationResponse", targetNamespace = "http://endpoint/", className = "endpoint.GetUserListForRegistrationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<endpoint.User> getUserListForRegistration();

    @WebMethod
    @Action(input = "http://endpoint/EndpointUser/getUserByIdRequest", output = "http://endpoint/EndpointUser/getUserByIdResponse")
    @RequestWrapper(localName = "getUserById", targetNamespace = "http://endpoint/", className = "endpoint.GetUserById")
    @ResponseWrapper(localName = "getUserByIdResponse", targetNamespace = "http://endpoint/", className = "endpoint.GetUserByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public endpoint.User getUserById(
        @WebParam(name = "arg0", targetNamespace = "")
        endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebMethod
    @Action(input = "http://endpoint/EndpointUser/getUserListRequest", output = "http://endpoint/EndpointUser/getUserListResponse")
    @RequestWrapper(localName = "getUserList", targetNamespace = "http://endpoint/", className = "endpoint.GetUserList")
    @ResponseWrapper(localName = "getUserListResponse", targetNamespace = "http://endpoint/", className = "endpoint.GetUserListResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<endpoint.User> getUserList(
        @WebParam(name = "arg0", targetNamespace = "")
        endpoint.Session arg0
    );

    @WebMethod
    @Action(input = "http://endpoint/EndpointUser/createUserRequest", output = "http://endpoint/EndpointUser/createUserResponse")
    @RequestWrapper(localName = "createUser", targetNamespace = "http://endpoint/", className = "endpoint.CreateUser")
    @ResponseWrapper(localName = "createUserResponse", targetNamespace = "http://endpoint/", className = "endpoint.CreateUserResponse")
    public void createUser(
        @WebParam(name = "arg0", targetNamespace = "")
        endpoint.User arg0
    );
}
