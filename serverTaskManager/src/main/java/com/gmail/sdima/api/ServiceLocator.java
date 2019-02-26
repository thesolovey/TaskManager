package com.gmail.sdima.api;

public interface ServiceLocator {

    IProjectService getiProjectService();
    ITaskService getiTaskService();
    ISessionService getiSessionService();
    IUserService getiUserService();
}
