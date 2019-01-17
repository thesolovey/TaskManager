package com.gmail.sdima9999.command.project;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;

public class ProjectDeleteCommand extends AbstractCommand {
    public ProjectDeleteCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public void execute() {
        System.out.println("[PROJECT DELETE]");
        bootstrap.getProjectService().deleteProject();
        System.out.println("[ОК]");
    }
}
