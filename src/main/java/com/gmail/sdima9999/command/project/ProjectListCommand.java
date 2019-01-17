package com.gmail.sdima9999.command.project;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;

public class ProjectListCommand extends AbstractCommand {
    public ProjectListCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }
    public void execute() {
        System.out.println("[PROJECT LIST]");
        bootstrap.getProjectService().getProjectListByName();
        System.out.println("[OK]");
    }
}
