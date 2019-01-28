package endpoint;

import api.ServiceLocator;
import webservice.WebProjectServices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class EndPointProject extends AbstractEndPoint {

    private ServiceLocator serviceLocator;

    public EndPointProject(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @WebMethod
    public void run() {

        Endpoint.publish("http://localhost:8080/project?wsdl", new WebProjectServices());
        
    }

    @Override
    public void create() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void findAll() {

    }
}
