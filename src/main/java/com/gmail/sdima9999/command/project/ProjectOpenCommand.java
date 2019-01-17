package com.gmail.sdima9999.command.project;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;

public class ProjectOpenCommand extends AbstractCommand {
    public ProjectOpenCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public void execute() {
        System.out.println("[PROJECT OPEN]");
        bootstrap.getProjectService().openProjectByName();
        System.out.println("[OK]");
    }
}
