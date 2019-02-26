package com.gmail.sdima.command.task;

import com.gmail.sdima.bootstrap.BootstrapClient;
import com.gmail.sdima.command.AbstractCommand;
import com.gmail.sdima.command.ReadFromConsole;
import com.gmail.sdima.endpoint.AccessForbiddenException_Exception;

public class TaskDeleteCommand extends AbstractCommand {
    public TaskDeleteCommand(BootstrapClient bootstrap) {
        super(bootstrap);
    }
    public TaskDeleteCommand() { }

    public void execute() {
        System.out.println("[TASK DELETE]");

        boolean checkTaskListIsEmpty = bootstrap.getEndpointTask().checkTaskListIsEmpty();
        if (checkTaskListIsEmpty) {
            System.out.println("!!!  You don't have any Task  !!!");
            System.out.println("!!! Try com.gmail.sdima.command 'task-create' !!!");
        }
        final String idTask = ReadFromConsole.readInputFromConsole("Enter ID Task you want to delete: ");
        try {
            bootstrap.getEndpointTask().deleteTask(BootstrapClient.getSessionCurrentUser(), idTask);
        } catch (AccessForbiddenException_Exception e) { e.printStackTrace(); }

        System.out.println("[OK]");
    }

    @Override
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return "task-delete"; }

    @Override
    public String description() { return "Delete selected Task"; }
}
