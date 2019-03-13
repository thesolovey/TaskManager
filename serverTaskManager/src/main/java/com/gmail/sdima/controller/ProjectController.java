package com.gmail.sdima.controller;

import com.gmail.sdima.entity.Project;
import com.gmail.sdima.exception.AccessForbiddenException;
import com.gmail.sdima.service.ProjectService;
import com.gmail.sdima.service.SessionService;
import com.gmail.sdima.service.TaskService;
import com.gmail.sdima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Controller
public class ProjectController {

    @Autowired private ProjectService projectService;
    @Autowired private SessionService sessionService;
    @Autowired private UserService userService;
    @Autowired private TaskService taskService;

    @RequestMapping("/projectList")
    public String projectlist(HttpServletRequest request, HttpServletResponse response) throws AccessForbiddenException {
//        sessionService.validateSession(CurrentSession.getSessionCurrentUser());
//        final List<Project> projectList = projectService.getProjectByUserId(CurrentSession.getSessionCurrentUser());
//        request.setAttribute("projectList", projectList);
        return "projectList";
    }

    @PostMapping("/projectList")
    public String goToProjectOpenForm(HttpServletRequest request) throws AccessForbiddenException {
//        sessionService.validateSession(CurrentSession.getSessionCurrentUser());
        final String projectId = request.getParameter("projectId");

        Project projects = null;
//        final List<String> taskList = taskService.getTaskByUserId(CurrentSession.getSessionCurrentUser());

//        final List<Project> projectList = projectService.getProjectByUserId(CurrentSession.getSessionCurrentUser());
//        for (Project project: projectList)
//            if (project.getId().equals(projectId)) {
//                projects = project;
//            }
//        request.getSession().setAttribute("projects", projects);
//        request.getSession().setAttribute("tasks", taskList);
        return "redirect:/projectOpen";
    }

    @RequestMapping("/projectCreate")
    public String showProjectCreateForm() throws AccessForbiddenException {
//        sessionService.validateSession(CurrentSession.getSessionCurrentUser());
        return "projectCreate";
    }

    @PostMapping("/projectCreate")
    public String addNewProject(HttpServletRequest request) throws AccessForbiddenException {
//        sessionService.validateSession(CurrentSession.getSessionCurrentUser());
        final Project project = new Project();
//        User user = userService.getUserById(CurrentSession.getSessionCurrentUser().getUserId());
        final String projectName = request.getParameter("projectName");
        final String id = UUID.randomUUID().toString();
//        final String userId = CurrentSession.getSessionCurrentUser().getUserId();
//        final String userName = user.getUserName();
//        final String userLogin = user.getLogin();

        project.setId(id);
        project.setName(projectName);
//        project.setUserId(userId);
//        project.setUserLogin(userLogin);
//        project.setUserName(userName);

        projectService.addProjectByList(project);
        return "redirect:/projectList";
    }

    @RequestMapping("/projectOpen")
    public String openprojectForm(HttpServletRequest request, HttpServletResponse response) throws AccessForbiddenException, ServletException, IOException {
//        sessionService.validateSession(CurrentSession.getSessionCurrentUser());
        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/views/projectOpen.jsp");
        requestDispatcher.forward(request, response);
        return "projectOpen";
    }

    @PostMapping("/projectOpen")
    public String openProject() {
        return "redirect:/projectDelete";
    }

    @RequestMapping("/projectDelete")
    public String projectDeleteForm(HttpServletRequest request, HttpServletResponse response) throws AccessForbiddenException, ServletException, IOException {
//        sessionService.validateSession(CurrentSession.getSessionCurrentUser());
        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/views/projectDelete.jsp");
        requestDispatcher.forward(request, response);
        return "projectDelete";
    }

    @PostMapping("/projectDelete")
    public  String deleteProject(HttpServletRequest request) {
        final String projectId = request.getParameter("projectId");
        taskService.deleteTaskByProjectId(projectId);
        projectService.deleteProject(projectId);
        return "redirect:/projectList";
    }
}
