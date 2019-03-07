package com.gmail.sdima.controller;

import com.gmail.sdima.command.UserAdminCreateCommand;
import com.gmail.sdima.command.UserTestCreateCommand;
import com.gmail.sdima.entity.User;
import com.gmail.sdima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired private UserService userService;
    @Autowired private UserAdminCreateCommand adminCreate;
    @Autowired private UserTestCreateCommand testCreate;

    @RequestMapping("/registration")
    public String showRegForm(){
        adminCreate.execute();
        testCreate.execute();
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute ("user") @Valid User user)  {
//        userService.addUserByList(user);
        return "redirect:/";
    }

}
