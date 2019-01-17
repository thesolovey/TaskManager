package com.gmail.sdima9999.command.task;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;

public class TaskClearCommand extends AbstractCommand {
    public TaskClearCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public void execute() {
        System.out.println("[TASK CLEAR]");
        bootstrap.getTaskService().clearTaskList();
        System.out.println("[OK]");
    }
}
