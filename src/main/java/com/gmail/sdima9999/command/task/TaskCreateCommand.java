package com.gmail.sdima9999.command.task;

import com.gmail.sdima9999.entity.Task;
import com.gmail.sdima9999.readfromconsole.ReadFromConsole;
import com.gmail.sdima9999.repository.TaskRepository;

import java.util.Date;
import java.util.UUID;

public class TaskCreateCommand {
    public static void execute() {
        System.out.println("[TASK CREATE]");
        Task task = new Task();
        String name = ReadFromConsole.readInputFromConsole("Input name Task: ");
        task.setName(name);

        String idTask = UUID.randomUUID().toString();
        task.setId(idTask);

        Date dateBegin = new Date();
        task.setDateBegin(dateBegin);

//        Date dateEnd = dateBegin.;
//        task.setDateEnd(dateEnd);

        TaskRepository.addTask(task);
        System.out.println("[OK]");
    }
}
