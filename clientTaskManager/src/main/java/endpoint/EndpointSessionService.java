package endpoint;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-02-19T18:11:09.491+03:00
 * Generated source version: 3.2.7
 *
 */
@WebServiceClient(name = "EndpointSessionService",
                  wsdlLocation = "http://localhost:8080/session?wsdl",
                  targetNamespace = "http://endpoint/")
public class EndpointSessionService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint/", "EndpointSessionService");
    public final static QName EndpointSessionPort = new QName("http://endpoint/", "EndpointSessionPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/session?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(EndpointSessionService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/session?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public EndpointSessionService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public EndpointSessionService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EndpointSessionService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public EndpointSessionService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public EndpointSessionService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public EndpointSessionService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns EndpointSession
     */
    @WebEndpoint(name = "EndpointSessionPort")
    public EndpointSession getEndpointSessionPort() {
        return super.getPort(EndpointSessionPort, EndpointSession.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EndpointSession
     */
    @WebEndpoint(name = "EndpointSessionPort")
    public EndpointSession getEndpointSessionPort(WebServiceFeature... features) {
        return super.getPort(EndpointSessionPort, EndpointSession.class, features);
    }

}
