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
 * 2019-01-30T18:08:44.262+03:00
 * Generated source version: 3.2.7
 *
 */
@WebServiceClient(name = "EndPointProjectService",
                  wsdlLocation = "http://localhost:8080/project?wsdl",
                  targetNamespace = "http://endpoint/")
public class EndPointProjectService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint/", "EndPointProjectService");
    public final static QName EndPointProjectPort = new QName("http://endpoint/", "EndPointProjectPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/project?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(EndPointProjectService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/project?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public EndPointProjectService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public EndPointProjectService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EndPointProjectService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public EndPointProjectService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public EndPointProjectService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public EndPointProjectService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns EndPointProject
     */
    @WebEndpoint(name = "EndPointProjectPort")
    public EndPointProject getEndPointProjectPort() {
        return super.getPort(EndPointProjectPort, EndPointProject.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EndPointProject
     */
    @WebEndpoint(name = "EndPointProjectPort")
    public EndPointProject getEndPointProjectPort(WebServiceFeature... features) {
        return super.getPort(EndPointProjectPort, EndPointProject.class, features);
    }

}
