package command.task;

import bootstrap.Bootstrap;
import command.AbstractCommand;

public class TaskClearCommand extends AbstractCommand {
    public TaskClearCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "task-clear";

    public void execute() {
        System.out.println("[TASK CLEAR]");
//        boolean checkTaskListIsEmpty = bootstrap.getiTaskService().checkTaskListIsEmpty();
//        if (checkTaskListIsEmpty) {
//            System.out.println("!!!  You don't have any Task  !!!");
//            System.out.println("!!! Try command 'task-createProject' !!!");
//        } else {
//            final String answerInConsole = ReadFromConsole.readInputFromConsole("Are you sure, you want to deleteProject all Task? Input: 'yes'");
//            if (answerInConsole.equals("yes")) {
//                bootstrap.getiTaskService().clearTaskList();
//                System.out.println("[!!! Tasks were deleted!!!] ");
//            }
//        }
        System.out.println("[OK]");
    }

    @Override
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return "Task-clear"; }

    @Override
    public String description() { return "Delete all Tasks"; }
}
