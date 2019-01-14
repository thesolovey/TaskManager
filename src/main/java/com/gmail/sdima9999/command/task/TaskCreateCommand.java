package com.gmail.sdima9999.command.task;

import com.gmail.sdima9999.entity.Task;
import com.gmail.sdima9999.readfromconsole.ReadFromConsole;
import com.gmail.sdima9999.repository.TaskRepository;

import java.util.Calendar;
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
        Calendar calendarBegin = Calendar.getInstance();
        Calendar calendarEnd = Calendar.getInstance();
        calendarBegin.setTime(dateBegin);
        calendarEnd.add(Calendar.WEEK_OF_MONTH, 2);

        task.setDateBegin(calendarBegin.getTime());

        task.setDateEnd(calendarEnd.getTime());

        TaskRepository.addTask(task);
        System.out.println("[OK]");
    }
}
