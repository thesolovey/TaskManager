package com.gmail.sdima.command.task;

import com.gmail.sdima.bootstrap.Bootstrap;
import com.gmail.sdima.command.AbstractCommand;
import com.gmail.sdima.command.ReadFromConsole;

public class TaskClearCommand extends AbstractCommand {
    public TaskClearCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "task-clear";

    public void execute() {
        System.out.println("[TASK CLEAR]");
        boolean checkTaskListIsEmpty = bootstrap.getTaskService().checkTaskListIsEmpty();
        if (checkTaskListIsEmpty) {
            System.out.println("!!!  You don't have any Task  !!!");
            System.out.println("!!! Try command 'task-create' !!!");
        } else {
            final String answerInConsole = ReadFromConsole.readInputFromConsole("Are you sure, you want to delete all Task? Input: 'yes'");
            if (answerInConsole.equals("yes")) {
                bootstrap.getTaskService().clearTaskList();
                System.out.println("[!!! Tasks were deleted!!!] ");
            }
        }
        System.out.println("[OK]");
    }

    @Override
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return null; }

    @Override
    public String description() { return null; }
}
