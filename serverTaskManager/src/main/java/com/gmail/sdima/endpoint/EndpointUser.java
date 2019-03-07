package com.gmail.sdima.endpoint;

//@WebService
//@Component
//public class EndpointUser {
//
//    @Autowired private UserService userService;
//    @Autowired private SessionService sessionService;
//
//    @WebMethod
//    public void createUser(@WebParam(name = "user") final User user) {
//        userService.addUserByList(user); }
//
//    @WebMethod
//    public List<User> getUserList(@WebParam(name = "session") final Session session) throws AccessForbiddenException {
//        sessionService.validateSession(session);
//        return userService.getUsersList();
//    }
//
//    @WebMethod
//    public List<User> getUserListForRegistration() { return userService.getUsersList(); }
//
//    @WebMethod
//    public User getUserById(@WebParam(name = "session") final Session session,
//                            @WebParam(name = "userId") final String userId) throws AccessForbiddenException {
//        sessionService.validateSession(session);
//        return userService.getUserById(userId); }
//}
