package com.gmail.sdima9999.command.task;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.console.ReadFromConsole;

public class TaskDeleteCommand extends AbstractCommand {
    public TaskDeleteCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public void execute() {
        System.out.println("[TASK DELETE]");

        boolean checkTaskListIsEmpty = bootstrap.getTaskService().checkTaskListIsEmpty();
        if (checkTaskListIsEmpty) {
            System.out.println("!!!  You don't have any Task  !!!");
            System.out.println("!!! Try command 'task-create' !!!");
        }
        String nameTask = ReadFromConsole.readInputFromConsole("Enter the name of the Task you want to delete: ");
        bootstrap.getTaskService().deleteTask(nameTask);

        System.out.println("[OK]");
    }

    @Override
    public void secure() {

    }
}
