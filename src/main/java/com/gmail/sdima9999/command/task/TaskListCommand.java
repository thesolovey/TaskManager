package com.gmail.sdima9999.command.task;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;

public class TaskListCommand extends AbstractCommand {
    public TaskListCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public void execute() {
        System.out.println("[TASK LIST]");
        bootstrap.getTaskService().getTaskListByName();
        System.out.println("[OK]");
    }
}
