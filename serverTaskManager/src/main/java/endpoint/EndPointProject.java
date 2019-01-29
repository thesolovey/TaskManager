package endpoint;

import entity.User;
import webservice.WebProjectServices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class EndPointProject {

    @WebMethod
    public void run() {

        Endpoint.publish("http://localhost:8080/project?wsdl", new WebProjectServices());

    }

    @WebMethod
    public void create(User newUser) {

    }

    @WebMethod
    public void delete() {

    }

    @WebMethod
    public void findAll() {

    }
}
