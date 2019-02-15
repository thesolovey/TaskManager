
package endpoint;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-02-15T13:23:20.952+03:00
 * Generated source version: 3.2.7
 */

@WebFault(name = "AccessForbiddenException", targetNamespace = "http://endpoint/")
public class AccessForbiddenException_Exception extends Exception {

    private endpoint.AccessForbiddenException accessForbiddenException;

    public AccessForbiddenException_Exception() {
        super();
    }

    public AccessForbiddenException_Exception(String message) {
        super(message);
    }

    public AccessForbiddenException_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public AccessForbiddenException_Exception(String message, endpoint.AccessForbiddenException accessForbiddenException) {
        super(message);
        this.accessForbiddenException = accessForbiddenException;
    }

    public AccessForbiddenException_Exception(String message, endpoint.AccessForbiddenException accessForbiddenException, java.lang.Throwable cause) {
        super(message, cause);
        this.accessForbiddenException = accessForbiddenException;
    }

    public endpoint.AccessForbiddenException getFaultInfo() {
        return this.accessForbiddenException;
    }
}
