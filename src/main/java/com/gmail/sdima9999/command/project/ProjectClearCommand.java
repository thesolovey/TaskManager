package com.gmail.sdima9999.command.project;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;

public class ProjectClearCommand extends AbstractCommand {
    public ProjectClearCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public void execute() {
        System.out.println("[PROJECT CLEAR]");
        bootstrap.getProjectService().clearAllProject();
        System.out.println("[OK]");
    }
}
