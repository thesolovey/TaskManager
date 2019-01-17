package com.gmail.sdima9999.command.task;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;

public class TaskDeleteCommand extends AbstractCommand {
    public TaskDeleteCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public void execute() {
        System.out.println("[TASK DELETE]");
        bootstrap.getTaskService().deleteTask();
        System.out.println("[OK]");
    }
}
