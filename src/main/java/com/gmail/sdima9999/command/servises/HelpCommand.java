package com.gmail.sdima9999.command.servises;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class HelpCommand extends AbstractCommand {
    public HelpCommand(Bootstrap bootstrap) { super(bootstrap); }

    @Override
    public void execute() {
        System.out.println("[HELP]");
        Set<String> commands = bootstrap.getCommands();
        for (String string : commands)
        System.out.println(string);
        this.secure();
        System.out.println("[OK}");
    }

    @Override
    public void secure() {
        User user = bootstrap.getUserService().getCurrentUser();
        bootstrap.getUserService().setCurrentUser(user);
    }
}
