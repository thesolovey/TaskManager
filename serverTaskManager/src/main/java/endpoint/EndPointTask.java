package endpoint;

import entity.User;
import webservice.WebTaskService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class EndPointTask  {

    @WebMethod
    public void run() {

        Endpoint.publish("http://localhost:8080/task?wsdl", new WebTaskService());

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
