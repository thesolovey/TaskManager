package com.gmail.sdima9999.command.task;

import com.gmail.sdima9999.ReadFromConsole;
import com.gmail.sdima9999.entity.Task;
import com.gmail.sdima9999.repository.TaskRepository;

public class TaskCreateCommand {
    public static void execute() {
        System.out.println("[TASK CREATE]");
        Task task = new Task();
        task.setName(ReadFromConsole.readInputFromConsole("Input name Task: "));
        TaskRepository.addTaskList(task.getName());
        System.out.println("[OK]");
    }
}
