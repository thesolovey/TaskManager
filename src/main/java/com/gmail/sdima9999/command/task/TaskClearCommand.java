package com.gmail.sdima9999.command.task;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.console.ReadFromConsole;

public class TaskClearCommand extends AbstractCommand {
    public TaskClearCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public void execute() {
        System.out.println("[TASK CLEAR]");
        boolean checkTaskListIsEmpty = bootstrap.getTaskService().checkTaskListIsEmpty();
        if (checkTaskListIsEmpty) {
            System.out.println("!!!  You don't have any Task  !!!");
            System.out.println("!!! Try command 'task-create' !!!");
        } else {
            String answerInConcole = ReadFromConsole.readInputFromConsole("Are you sure, you want to delete all Task? Input: 'yes'");
            if (answerInConcole.equals("yes")) {
                bootstrap.getTaskService().clearTaskList();
                System.out.println("[!!! Tasks were delete!!!] ");
            }
        }
        System.out.println("[OK]");
    }
}
