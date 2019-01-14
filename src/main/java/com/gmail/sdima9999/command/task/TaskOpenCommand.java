package com.gmail.sdima9999.command.task;

import com.gmail.sdima9999.readfromconsole.ReadFromConsole;
import com.gmail.sdima9999.repository.TaskRepository;

public class TaskOpenCommand {
    public static void execute(){
        String name = ReadFromConsole.readInputFromConsole()
        TaskRepository.openTask();
    }
}
