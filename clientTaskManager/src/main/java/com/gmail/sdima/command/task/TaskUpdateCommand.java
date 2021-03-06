package com.gmail.sdima.command.task;

import com.gmail.sdima.bootstrap.BootstrapClient;
import com.gmail.sdima.command.AbstractCommand;

public class TaskUpdateCommand extends AbstractCommand {
    public TaskUpdateCommand(BootstrapClient bootstrap) { super(bootstrap); }
    public TaskUpdateCommand() { }

    public void execute() {
        System.out.println("[TASK UPDATE]");

//        boolean checkTaskListIsEmpty = com.gmail.sdima.bootstrap.getTaskService().checkTaskListIsEmpty();
//        if (checkTaskListIsEmpty) {
//            System.out.println("!!!  You don't have any Task  !!!");
//            System.out.println("!!! Try com.gmail.sdima.command 'task-create' !!!");
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
//        com.gmail.sdima.bootstrap.getTaskService().updateTask(name, newName, calendarEnd.getTime());
        System.out.println("[OK]");
    }

    @Override
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return "task-update"; }

    @Override
    public String description() { return "Update selected Task"; }
}
