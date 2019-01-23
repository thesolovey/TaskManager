package com.gmail.sdima.webservice;

import com.gmail.sdima.entity.Project;
import com.gmail.sdima.service.ProjectService;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "com.gmail.sdima.webservice.WebServicesProject")

public class WebServicesProject {

    @WebMethod
    public void createProject(Project project) {
        ProjectService projectService = null;
        try {
            projectService.addProjectByList(project);
        } catch (NullPointerException e) {e.printStackTrace();}
    }
}
