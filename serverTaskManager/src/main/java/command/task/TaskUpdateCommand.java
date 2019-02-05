package command.task;

import bootstrap.Bootstrap;
import command.AbstractCommand;

public class TaskUpdateCommand extends AbstractCommand {
    public TaskUpdateCommand(Bootstrap bootstrap) { super(bootstrap); }

    public static final String COMMAND = "task-update";

    public void execute() {
        System.out.println("[TASK UPDATE]");

//        boolean checkTaskListIsEmpty = bootstrap.getiTaskService().checkTaskListIsEmpty();
//        if (checkTaskListIsEmpty) {
//            System.out.println("!!!  You don't have any Task  !!!");
//            System.out.println("!!! Try command 'task-createProject' !!!");
//        }
//        String name = ReadFromConsole.readInputFromConsole("Enter the name of the Task you want to exchange: ");
//        String newName = ReadFromConsole.readInputFromConsole("Enter new name: ");
//        Calendar calendarEnd = Calendar.getInstance();
//
//        System.out.println("How many days to complete this Task?: ");
//        Scanner scanner = new Scanner(System.in);
//        int newDateEnd = scanner.nextInt();
//        calendarEnd.add(Calendar.DATE, newDateEnd);
//
//        bootstrap.getiTaskService().updateTask(name, newName, calendarEnd.getTime());
        System.out.println("[OK]");
    }

    @Override
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return "task-update"; }

    @Override
    public String description() { return "Update selected Task"; }
}
