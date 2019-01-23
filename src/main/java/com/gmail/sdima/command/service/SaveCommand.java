package com.gmail.sdima.command.service;

import com.gmail.sdima.bootstrap.Bootstrap;
import com.gmail.sdima.command.AbstractCommand;

public class SaveCommand extends AbstractCommand {

    public SaveCommand(Bootstrap bootstrap) { super(bootstrap); }

    @Override
    public void execute() {
        bootstrap.getProjectService().writeObject();
        bootstrap.getTaskService().writeObject();
        bootstrap.getUserService().writeObject();
    }

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public String getKeyWord() {
        return null;
    }

    @Override
    public String description() {
        return null;
    }
}
