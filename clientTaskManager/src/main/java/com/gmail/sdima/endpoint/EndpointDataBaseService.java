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
 * 2019-01-31T17:41:05.288+03:00
 * Generated source version: 3.2.7
 *
 */
@WebServiceClient(name = "EndpointDataBaseService",
                  wsdlLocation = "http://localhost:8080/database?wsdl",
                  targetNamespace = "http://com.gmail.sdima.endpoint/")
public class EndpointDataBaseService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://com.gmail.sdima.endpoint/", "EndpointDataBaseService");
    public final static QName EndpointDataBasePort = new QName("http://com.gmail.sdima.endpoint/", "EndpointDataBasePort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/database?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(EndpointDataBaseService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/database?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public EndpointDataBaseService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public EndpointDataBaseService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EndpointDataBaseService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public EndpointDataBaseService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public EndpointDataBaseService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public EndpointDataBaseService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns EndpointDataBase
     */
    @WebEndpoint(name = "EndpointDataBasePort")
    public EndpointDataBase getEndpointDataBasePort() {
        return super.getPort(EndpointDataBasePort, EndpointDataBase.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EndpointDataBase
     */
    @WebEndpoint(name = "EndpointDataBasePort")
    public EndpointDataBase getEndpointDataBasePort(WebServiceFeature... features) {
        return super.getPort(EndpointDataBasePort, EndpointDataBase.class, features);
    }

}
