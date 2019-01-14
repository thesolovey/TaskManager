package com.gmail.sdima9999.command.task;

import com.gmail.sdima9999.readfromconsole.ReadFromConsole;
import com.gmail.sdima9999.repository.TaskRepository;

public class TaskUpdateCommand {
    public static void execute() {
        System.out.println("[TASK UPDATE]");
        String name = ReadFromConsole.readInputFromConsole("Enter the name of the Task you want to exchange: ");
//        if (TaskRepository.taskList.contains(name)) {
  //          TaskRepository.changeTaskList(name, ReadFromConsole.readInputFromConsole("Enter new name: "));
            System.out.println("[OK]");
  //      } else System.out.println("Invalid name Task");
    }
}
