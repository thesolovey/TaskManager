package command.task;

import bootstrap.BootstrapClient;
import command.AbstractCommand;
import command.ReadFromConsole;
import endpoint.AccessForbiddenException_Exception;
import endpoint.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskOpenCommand extends AbstractCommand {
    public TaskOpenCommand(BootstrapClient bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "task-open";

    public void execute() {
        System.out.println("[TASK OPEN]");

        boolean checkTaskListIsEmpty = bootstrap.getEndpointTask().checkTaskListIsEmpty();
        if (checkTaskListIsEmpty) {
            System.out.println("!!!  You don't have any Task  !!!");
            System.out.println("!!! Try command 'task-create' !!!");
        } else {
            final String nameTask = ReadFromConsole.readInputFromConsole("Enter Task you want open: ");
            List<Task> taskListByName = new ArrayList<>();
            try {
                taskListByName = bootstrap.getEndpointTask().openTaskByName(BootstrapClient.getSessionCurrentUser(), nameTask);
            } catch (AccessForbiddenException_Exception e) { e.printStackTrace(); }
            for (Task task : taskListByName) {
                System.out.println("Name Project for this Task: " + task.getNameByProject());
                System.out.println("Name Task: " + task.getName());
                System.out.println("Task ID: " + task.getId());
                System.out.println("Task Date Begin: " + task.getDateBegin());
                System.out.println("Task Date End: " + task.getDateEnd());
            }
            System.out.println("[OK]");
        }
    }

    @Override
    public boolean secure() { return false; }

    @Override
    public String getKeyWord() { return "task-open"; }

    @Override
    public String description() { return "Open selected Task"; }
}
