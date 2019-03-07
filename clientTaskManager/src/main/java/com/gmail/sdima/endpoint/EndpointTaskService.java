package com.gmail.sdima.endpoint;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-03-01T18:04:43.835+03:00
 * Generated source version: 3.2.7
 *
 */
@WebServiceClient(name = "EndpointTaskService",
                  wsdlLocation = "http://localhost:8080/task?wsdl",
                  targetNamespace = "http://endpoint.sdima.gmail.com/")
public class EndpointTaskService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint.sdima.gmail.com/", "EndpointTaskService");
    public final static QName EndpointTaskPort = new QName("http://endpoint.sdima.gmail.com/", "EndpointTaskPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/task?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(EndpointTaskService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/task?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public EndpointTaskService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public EndpointTaskService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EndpointTaskService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public EndpointTaskService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public EndpointTaskService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public EndpointTaskService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns EndpointTask
     */
    @WebEndpoint(name = "EndpointTaskPort")
    public EndpointTask getEndpointTaskPort() {
        return super.getPort(EndpointTaskPort, EndpointTask.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EndpointTask
     */
    @WebEndpoint(name = "EndpointTaskPort")
    public EndpointTask getEndpointTaskPort(WebServiceFeature... features) {
        return super.getPort(EndpointTaskPort, EndpointTask.class, features);
    }

}
