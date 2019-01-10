package com.gmail.sdima9999.command.task;

import com.gmail.sdima9999.repository.TaskRepository;

public class TaskListCommand {
    public static void execute() {
        System.out.println("[TASK LIST]");
        System.out.println(TaskRepository.myTaskList);
    }
}
