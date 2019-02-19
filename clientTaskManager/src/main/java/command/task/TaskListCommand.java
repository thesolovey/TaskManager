package command.task;

import bootstrap.BootstrapClient;
import command.AbstractCommand;
import endpoint.AccessForbiddenException_Exception;

import java.util.ArrayList;
import java.util.List;

public class TaskListCommand extends AbstractCommand {
    public TaskListCommand(BootstrapClient bootstrap) {
        super(bootstrap);
    }
    public TaskListCommand() { }

    public void execute() {
        System.out.println("[TASK LIST]");

        boolean checkTaskListIsEmpty = bootstrap.getEndpointTask().checkTaskListIsEmpty();
        if (checkTaskListIsEmpty) {
            System.out.println("!!!  You don't have any Task  !!!");
            System.out.println("!!! Try command 'task-create' !!!");
        }

        List<String> allTask = new ArrayList<>();
        try {
            allTask = bootstrap.getEndpointTask().findAllTask(BootstrapClient.getSessionCurrentUser());
        } catch (AccessForbiddenException_Exception e) { e.printStackTrace(); }
        for (String task : allTask)
            System.out.println(task);

        System.out.println("[OK]");
    }

    @Override
    public boolean secure() { return false; }

    @Override
    public String getKeyWord() { return "task-list"; }

    @Override
    public String description() { return "Shows list Tasks"; }
}
