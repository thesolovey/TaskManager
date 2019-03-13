package com.gmail.sdima.controller;

import com.gmail.sdima.service.SessionService;
import com.gmail.sdima.service.TaskService;
import com.gmail.sdima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TaskController {

    @Autowired private UserService userService;
    @Autowired private SessionService sessionService;
    @Autowired private TaskService taskService;

    @RequestMapping("/taskList")
    public String taskList(HttpServletRequest request) {
//        List<String> taskList = taskService.getTaskByUserId(CurrentSession.getSessionCurrentUser());
 //       request.getSession().setAttribute("taskList", taskList);
        return "taskList";
    }

}
