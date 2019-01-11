package com.gmail.sdima9999.command.task;

import com.gmail.sdima9999.ReadFromConsole;
import com.gmail.sdima9999.repository.TaskRepository;

public class TaskDeleteCommand {
    public static void execute() {
        System.out.println("[TASK DELETE]");
        String name = ReadFromConsole.readInputFromConsole("Enter the name of the Task you want to delete: ");
        if (TaskRepository.myTaskList.contains(name)) {
            TaskRepository.removeTaskList(name);
            System.out.println("[OK]");
        } else System.out.println("Invalid name of Task");
    }
}
