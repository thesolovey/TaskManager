package api;

public interface ServiceLocator {

    IUserService getUserService();
    IProjectService getProjectService();
    ITaskService getTaskService();

}
