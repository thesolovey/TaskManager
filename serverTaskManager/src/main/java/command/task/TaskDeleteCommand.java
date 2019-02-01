package command.task;

import bootstrap.Bootstrap;
import command.AbstractCommand;

public class TaskDeleteCommand extends AbstractCommand {
    public TaskDeleteCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "task-deleteProject";

    public void execute() {
        System.out.println("[TASK DELETE]");

//        boolean checkTaskListIsEmpty = bootstrap.getTaskService().checkTaskListIsEmpty();
//        if (checkTaskListIsEmpty) {
//            System.out.println("!!!  You don't have any Task  !!!");
//            System.out.println("!!! Try command 'task-createProject' !!!");
//        }
//        final String idTask = ReadFromConsole.readInputFromConsole("Enter ID Task you want to deleteProject: ");
//        bootstrap.getTaskService().deleteTask(idTask);

        System.out.println("[OK]");
    }

    @Override
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return "task-deleteProject"; }

    @Override
    public String description() { return "Delete selected Task"; }
}
