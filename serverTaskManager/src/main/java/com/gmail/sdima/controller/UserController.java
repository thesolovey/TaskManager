package com.gmail.sdima.controller;
import com.gmail.sdima.entity.*;
import com.gmail.sdima.exception.AccessForbiddenException;
import com.gmail.sdima.service.ProjectService;
import com.gmail.sdima.service.SessionService;
import com.gmail.sdima.service.TaskService;
import com.gmail.sdima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {

    @Autowired private UserService userService;
    @Autowired private SessionService sessionService;
    @Autowired private ProjectService projectService;
    @Autowired private TaskService taskService;
    @Autowired private BCryptPasswordEncoder passwordEncoder;
    private final User user = new User();

    @GetMapping("/registration")
    public String showRegForm(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(HttpServletRequest request)  {
        final String id = UUID.randomUUID().toString();
        final String login = request.getParameter("login");
        final String password = request.getParameter("password");
        final String userName = request.getParameter("userName");
        final String passwordHash = passwordEncoder.encode(password);
        user.setLogin(login);
        user.setPassword(passwordHash);
        user.setId(id);
        user.setUserName(userName);
        userService.addUserByList(user);
        return "redirect:/";
    }

    @RequestMapping("/authorization")
    public String showAuthForm() {
        return "authorization";
    }

    @PostMapping("/authorization")
    public String authUser(HttpServletRequest request) {
        final List<User> userList = userService.getUsersList();
        User userForMainPage = new User();
        final String login = request.getParameter("login");
        final String password = request.getParameter("password");
        final String passwordHash = passwordEncoder.encode(password);
        for (User user : userList) {
            if (user.getLogin().equals(login) && user.getPassword().equals(passwordHash)) {
//                final String userId = user.getId();
//                final Session session = sessionService.getNewSession(userId);
//                CurrentSession.setSessionCurrentUser(session);
                userForMainPage = user;
            }
            request.getSession().setAttribute("user", userForMainPage);
        }
        return "redirect:/userMainPage";
    }

    @RequestMapping("/userMainPage")
    public String userMainPage(HttpServletRequest request) throws AccessForbiddenException {
//        sessionService.validateSession(CurrentSession.getSessionCurrentUser());
        final String login = request.getParameter("login");
//        final List<Project> projectList = projectService.getProjectByUserId(CurrentSession.getSessionCurrentUser());
//        final List<String> taskList = taskService.getTaskByUserId(CurrentSession.getSessionCurrentUser());
//        request.getSession().setAttribute("projectList", projectList);
//        request.getSession().setAttribute("taskList", taskList);
        return "userMainPage";
    }

}
