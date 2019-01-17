package com.gmail.sdima9999.command.task;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;

public class TaskOpenCommand extends AbstractCommand {
    public TaskOpenCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public void execute(){
        System.out.println("[TASK OPEN]");
        bootstrap.getTaskService().openTaskByName();
        System.out.println("[OK]");
    }
}
