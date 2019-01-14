package com.gmail.sdima9999.command.task;

import com.gmail.sdima9999.readfromconsole.ReadFromConsole;
import com.gmail.sdima9999.repository.TaskRepository;

public class TaskOpenCommand {
    public static void execute(){
        System.out.println("[TASK OPEN]");
        String name = ReadFromConsole.readInputFromConsole("Enter Task you want open: ");
        TaskRepository.openTask(name);
        System.out.println("[OK]");
    }
}
