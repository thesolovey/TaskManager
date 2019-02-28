package com.gmail.sdima.bootstrap;

import com.gmail.sdima.command.UserAdminCreateCommand;
import com.gmail.sdima.command.UserTestCreateCommand;
import com.gmail.sdima.endpoint.EndpointProject;
import com.gmail.sdima.endpoint.EndpointSession;
import com.gmail.sdima.endpoint.EndpointTask;
import com.gmail.sdima.endpoint.EndpointUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Endpoint;

@Service
public class Bootstrap {

    @Autowired private UserAdminCreateCommand adminCreate;
    @Autowired private UserTestCreateCommand testCreate;
    @Autowired private EndpointUser endpointUser;
    @Autowired private EndpointSession endpointSession;
    @Autowired private EndpointProject endpointProject;
    @Autowired private EndpointTask endpointTask;

    private void publishEndpoint() {
        Endpoint.publish("http://localhost:8080/user?wsdl", endpointUser);
        Endpoint.publish("http://localhost:8080/session?wsdl", endpointSession);
        Endpoint.publish("http://localhost:8080/project?wsdl", endpointProject);
        Endpoint.publish("http://localhost:8080/task?wsdl", endpointTask);
    }

    public void start() {
        publishEndpoint();
        adminCreate.execute();
        testCreate.execute();
        System.out.println("***SERVER RUN***");
        do { } while (true);
    }
 }