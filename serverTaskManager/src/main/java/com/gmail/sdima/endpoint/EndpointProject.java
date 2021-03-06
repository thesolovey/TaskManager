package com.gmail.sdima.endpoint;

//@WebService
//@Component
//public class EndpointProject {
//
//    @Autowired private ProjectService projectService;
//    @Autowired private SessionService sessionService;
//
//    @WebMethod
//    public void createProject (@WebParam(name = "session") final Session session,
//                               @WebParam(name = "project") final Project project) throws AccessForbiddenException {
//        sessionService.validateSession(session);
//        projectService.addProjectByList(project);
//    }
//
//    @WebMethod
//    public void deleteProject(@WebParam(name = "session") final Session session,
//                              @WebParam(name = "idProject") final String idProject) throws AccessForbiddenException {
//        sessionService.validateSession(session);
//        projectService.deleteProject(idProject);
//    }
//
//    @WebMethod
//    public List<Project> getProjectByUserId(@WebParam(name = "session") final Session session) throws AccessForbiddenException {
//        sessionService.validateSession(session);
//        return projectService.getProjectByUserId(session);
//    }
//
//    @WebMethod
//    public boolean checkProjectListIsEmpty() { return projectService.checkProjectListIsEmpty(); }
//}
