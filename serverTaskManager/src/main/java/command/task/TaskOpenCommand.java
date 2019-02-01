package command.task;

import bootstrap.Bootstrap;
import command.AbstractCommand;
import command.ReadFromConsole;
import entity.Task;

import java.util.List;

public class TaskOpenCommand extends AbstractCommand {
    public TaskOpenCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "task-open";

    public void execute() {
        System.out.println("[TASK OPEN]");

        boolean checkTaskListIsEmpty = bootstrap.getTaskService().checkTaskListIsEmpty();
        if (checkTaskListIsEmpty) {
            System.out.println("!!!  You don't have any Task  !!!");
            System.out.println("!!! Try command 'task-createProject' !!!");
        } else {
            final String name = ReadFromConsole.readInputFromConsole("Enter Task you want open: ");
            final List<Task> taskListByName = bootstrap.getTaskService().openTaskByName(name);
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
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return "task-open"; }

    @Override
    public String description() { return "Open selected Task"; }
}