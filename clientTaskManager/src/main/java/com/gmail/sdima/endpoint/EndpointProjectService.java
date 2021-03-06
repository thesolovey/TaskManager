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
 * 2019-03-01T18:04:43.519+03:00
 * Generated source version: 3.2.7
 *
 */
@WebServiceClient(name = "EndpointProjectService",
                  wsdlLocation = "http://localhost:8080/project?wsdl",
                  targetNamespace = "http://endpoint.sdima.gmail.com/")
public class EndpointProjectService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint.sdima.gmail.com/", "EndpointProjectService");
    public final static QName EndpointProjectPort = new QName("http://endpoint.sdima.gmail.com/", "EndpointProjectPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/project?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(EndpointProjectService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/project?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public EndpointProjectService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public EndpointProjectService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EndpointProjectService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public EndpointProjectService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public EndpointProjectService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public EndpointProjectService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns EndpointProject
     */
    @WebEndpoint(name = "EndpointProjectPort")
    public EndpointProject getEndpointProjectPort() {
        return super.getPort(EndpointProjectPort, EndpointProject.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EndpointProject
     */
    @WebEndpoint(name = "EndpointProjectPort")
    public EndpointProject getEndpointProjectPort(WebServiceFeature... features) {
        return super.getPort(EndpointProjectPort, EndpointProject.class, features);
    }

}
