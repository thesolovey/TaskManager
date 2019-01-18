package com.gmail.sdima9999.command.task;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.console.ReadFromConsole;

public class TaskUpdateCommand extends AbstractCommand {
    public TaskUpdateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public void execute() {
        System.out.println("[TASK UPDATE]");

        boolean checkTaskListIsEmpty = bootstrap.getTaskService().checkTaskListIsEmpty();
        if (checkTaskListIsEmpty) {
            System.out.println("!!!  You don't have any Task  !!!");
            System.out.println("!!! Try command 'task-create' !!!");
        }
        String name = ReadFromConsole.readInputFromConsole("Enter the name of the Task you want to exchange: ");
        String newName = ReadFromConsole.readInputFromConsole("Enter new name: ");

        bootstrap.getTaskService().updateNameTask(name, newName);
        System.out.println("[OK]");

    }

    @Override
    public void secure() {

    }
}
