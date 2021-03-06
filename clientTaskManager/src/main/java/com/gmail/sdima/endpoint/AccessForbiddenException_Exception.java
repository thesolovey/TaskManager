
package com.gmail.sdima.endpoint;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-03-01T18:04:43.822+03:00
 * Generated source version: 3.2.7
 */

@WebFault(name = "AccessForbiddenException", targetNamespace = "http://endpoint.sdima.gmail.com/")
public class AccessForbiddenException_Exception extends Exception {

    private com.gmail.sdima.endpoint.AccessForbiddenException accessForbiddenException;

    public AccessForbiddenException_Exception() {
        super();
    }

    public AccessForbiddenException_Exception(String message) {
        super(message);
    }

    public AccessForbiddenException_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public AccessForbiddenException_Exception(String message, com.gmail.sdima.endpoint.AccessForbiddenException accessForbiddenException) {
        super(message);
        this.accessForbiddenException = accessForbiddenException;
    }

    public AccessForbiddenException_Exception(String message, com.gmail.sdima.endpoint.AccessForbiddenException accessForbiddenException, java.lang.Throwable cause) {
        super(message, cause);
        this.accessForbiddenException = accessForbiddenException;
    }

    public com.gmail.sdima.endpoint.AccessForbiddenException getFaultInfo() {
        return this.accessForbiddenException;
    }
}
