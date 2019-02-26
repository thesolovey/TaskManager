package com.gmail.sdima.command.service;

import com.gmail.sdima.bootstrap.BootstrapClient;
import com.gmail.sdima.command.AbstractCommand;

import java.util.Set;

public class HelpCommand extends AbstractCommand {
    public HelpCommand(BootstrapClient bootstrap) { super(bootstrap); }
    public HelpCommand() { }

    @Override
    public void execute() {
        System.out.println("[HELP]");
        Set<String> commands = bootstrap.getCommand();
        for (String string : commands)
        System.out.println(string);
        System.out.println("[OK}");
    }

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public String getKeyWord() { return "help"; }

    @Override
    public String description() { return "Shows all commands"; }

}
