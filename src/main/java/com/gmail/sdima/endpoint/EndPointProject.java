package com.gmail.sdima.endpoint;

import com.gmail.sdima.webservice.WebProjectServices;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class EndPointProject {
    public static void run() {

        Endpoint.publish("http://localhost:1986/wss/hello", new WebProjectServices());

    }
}
