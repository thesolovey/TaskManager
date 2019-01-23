package com.gmail.sdima.endpoint;

import com.gmail.sdima.webservice.WebServicesProject;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class endPointProject {
    public static void main(String[] args) {

        Endpoint.publish("http://localhost:1986/wss/hello", new WebServicesProject());

    }
}
