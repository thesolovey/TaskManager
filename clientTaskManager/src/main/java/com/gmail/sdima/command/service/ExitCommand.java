package com.gmail.sdima.command.service;

import com.gmail.sdima.bootstrap.BootstrapClient;
import com.gmail.sdima.command.AbstractCommand;

public class ExitCommand extends AbstractCommand {
    public ExitCommand(BootstrapClient bootstrap) { super(bootstrap); }
    public ExitCommand() { }

    @Override
    public void execute() {
        System.out.println("Good bye!");
    }

    @Override
    public boolean secure() { return false; }

    @Override
    public String getKeyWord() { return "exit"; }

    @Override
    public String description() { return "Exit from TaskManager"; }
}
