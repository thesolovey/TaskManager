package com.gmail.sdima.bootstrap;

import com.gmail.sdima.command.UserAdminCreateCommand;
import com.gmail.sdima.command.UserTestCreateCommand;
import com.gmail.sdima.endpoint.EndpointProject;
import com.gmail.sdima.endpoint.EndpointSession;
import com.gmail.sdima.endpoint.EndpointTask;
import com.gmail.sdima.endpoint.EndpointUser;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.xml.ws.Endpoint;

@ApplicationScoped
public class Bootstrap {

    @Inject private UserAdminCreateCommand adminCreate;
    @Inject private UserTestCreateCommand testCreate;
    @Inject private EndpointUser endpointUser;
    @Inject private EndpointSession endpointSession;
    @Inject private EndpointProject endpointProject;
    @Inject private EndpointTask endpointTask;

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