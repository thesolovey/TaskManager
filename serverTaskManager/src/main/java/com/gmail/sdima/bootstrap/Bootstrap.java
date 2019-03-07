package com.gmail.sdima.bootstrap;

//@Service
//public class Bootstrap {
//
//    @Autowired private UserAdminCreateCommand adminCreate;
//    @Autowired private UserTestCreateCommand testCreate;
//    @Autowired private EndpointUser endpointUser;
//    @Autowired private EndpointSession endpointSession;
//    @Autowired private EndpointProject endpointProject;
//    @Autowired private EndpointTask endpointTask;
//
//    private void publishEndpoint() {
//        Endpoint.publish("http://localhost:8081/user?wsdl", endpointUser);
//        Endpoint.publish("http://localhost:8081/session?wsdl", endpointSession);
//        Endpoint.publish("http://localhost:8081/project?wsdl", endpointProject);
//        Endpoint.publish("http://localhost:8081/task?wsdl", endpointTask);
//    }
//
//    public void start() {
//        publishEndpoint();
//        adminCreate.execute();
//        testCreate.execute();
//        System.out.println("***SERVER RUN***");
//        do { } while (true);
//    }
// }