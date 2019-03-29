package com.gmail.sdima.controller;

import com.gmail.sdima.command.UserAdminCreateCommand;
import com.gmail.sdima.command.UserTestCreateCommand;
import com.gmail.sdima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired private UserService userService;
    @Autowired private UserAdminCreateCommand userAdmin;
    @Autowired private UserTestCreateCommand userTest;

        @GetMapping("/")
        public String home(Model model) throws SQLException {
            if (userService.checkUserListIsEmpty()) {
                userAdmin.execute();
                userTest.execute();
            }
            return "homePage";
        }
    }
