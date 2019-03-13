package com.gmail.sdima.command;

import com.gmail.sdima.entity.User;
import com.gmail.sdima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserAdminCreateCommand {

    @Autowired private UserService userService;
    @Autowired private BCryptPasswordEncoder passwordEncoder;

    public void execute() {
        final User admin = new User();
        final String login = "admin";
        final String password = "admin";
        final String passwordHash = passwordEncoder.encode(password);
        final String userName = "admin";
        final String userId = UUID.randomUUID().toString();

        admin.setLogin(login);
        admin.setPassword(passwordHash);
        admin.setUserName(userName);
        admin.setId(userId);

        userService.addUserByList(admin);
    }
}
