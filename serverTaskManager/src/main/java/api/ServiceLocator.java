package api;

public interface ServiceLocator {

    IProjectService getiProjectService();
    ITaskService getiTaskService();
    ISessionService getiSessionService();
    IUserService getiUserService();
}
