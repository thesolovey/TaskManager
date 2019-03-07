package com.gmail.sdima.endpoint;

//@WebService
//@Component
//public class EndpointTask  {
//
//    @Autowired private TaskService taskService;
//    @Autowired private ProjectService projectService;
//    @Autowired private SessionService sessionService;
//
//    @WebMethod
//    public void createTask(@WebParam(name = "session") final Session session,
//                           @WebParam(name = "task") final TaskDTO task) throws AccessForbiddenException {
//        final Project project = projectService.getProjectById(task.getIdByProject());
//        sessionService.validateSession(session);
//        taskService.addTask(task, project);
//    }
//
//    @WebMethod
//    public void deleteTask(@WebParam(name = "session") final Session session,
//                           @WebParam(name = "idTask") final String idTask) throws AccessForbiddenException {
//        sessionService.validateSession(session);
//        taskService.deleteTask(idTask);
//    }
//
//    @WebMethod
//    public List<String> findAllTask(@WebParam(name = "session") final Session session) throws AccessForbiddenException {
//        sessionService.validateSession(session);
//        return taskService.getTaskByUserId(session);
//    }
//
//    @WebMethod
//    public List<Task> openTaskByName(@WebParam(name = "session") final Session session,
//                                     @WebParam(name = "nameTask") final String nameTask) throws AccessForbiddenException {
//        sessionService.validateSession(session);
//        return taskService.openTaskByName(nameTask);
//    }
//
//    @WebMethod
//    public void deleteTaskByIdProjecr(@WebParam(name = "session") final Session session,
//                                      @WebParam(name = "idProject") final String idProject) throws AccessForbiddenException {
//        sessionService.validateSession(session);
//        taskService.deleteTaskByProjectId(idProject); }
//
//    @WebMethod
//    public boolean checkTaskListIsEmpty() { return taskService.checkTaskListIsEmpty(); }
//
//    @WebMethod
//    public List<String> getTaskByProjectName(@WebParam(name = "session") final Session session,
//                                           @WebParam(name = "projectName") final String projectName) throws AccessForbiddenException {
//        sessionService.validateSession(session);
//        return taskService.getTaskByProjectName(projectName); }
//}
