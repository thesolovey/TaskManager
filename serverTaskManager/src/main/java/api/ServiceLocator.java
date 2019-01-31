package api;

public interface ServiceLocator {

    IProjectServise getProjectService();
    ITaskService getTaskService();
    ISessionService getSessionService();
    IUserService getUserService();

}
