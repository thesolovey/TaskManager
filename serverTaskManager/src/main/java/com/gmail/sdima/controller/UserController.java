package com.gmail.sdima.controller;

import com.gmail.sdima.entity.User;
import com.gmail.sdima.service.ProjectService;
import com.gmail.sdima.service.SessionService;
import com.gmail.sdima.service.TaskService;
import com.gmail.sdima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
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
        final String passwordEncode = passwordEncoder.encode(password);
        user.setLogin(login);
        user.setPassword(passwordEncode);
        user.setId(id);
        user.setUserName(userName);
        userService.addUserByList(user);
        return "redirect:/";
    }

//    @GetMapping("/login")
//    public String showAuth(Model model) {
//        model.addAttribute("user", new User());
//        return "login";
//    }

//    @PostMapping("/login")
//    public String showAuthForm(Model model) {
//        model.addAttribute("user", new User());
//        return "/userMainPage";
//    }

    @GetMapping("/userMainPage")
    public String userMainPage(Model model, Principal principal) {

        return "userMainPage";
    }
}
