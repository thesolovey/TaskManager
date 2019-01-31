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
 * 2019-01-31T12:46:16.046+03:00
 * Generated source version: 3.2.7
 *
 */
@WebServiceClient(name = "TaskEndPointService",
                  wsdlLocation = "http://localhost:8080/task?wsdl",
                  targetNamespace = "http://endpoint/")
public class TaskEndPointService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint/", "TaskEndPointService");
    public final static QName TaskEndPointPort = new QName("http://endpoint/", "TaskEndPointPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/task?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(TaskEndPointService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/task?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public TaskEndPointService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TaskEndPointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TaskEndPointService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public TaskEndPointService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public TaskEndPointService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public TaskEndPointService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns TaskEndPoint
     */
    @WebEndpoint(name = "TaskEndPointPort")
    public TaskEndPoint getTaskEndPointPort() {
        return super.getPort(TaskEndPointPort, TaskEndPoint.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TaskEndPoint
     */
    @WebEndpoint(name = "TaskEndPointPort")
    public TaskEndPoint getTaskEndPointPort(WebServiceFeature... features) {
        return super.getPort(TaskEndPointPort, TaskEndPoint.class, features);
    }

}
