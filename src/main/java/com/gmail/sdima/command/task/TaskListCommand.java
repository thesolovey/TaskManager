package com.gmail.sdima.command.task;

import com.gmail.sdima.bootstrap.Bootstrap;
import com.gmail.sdima.command.AbstractCommand;
import com.gmail.sdima.entity.Task;

import java.util.List;

public class TaskListCommand extends AbstractCommand {
    public TaskListCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "task-list";

    public void execute() {
        System.out.println("[TASK LIST]");

        boolean checkTaskListIsEmpty = bootstrap.getTaskService().checkTaskListIsEmpty();
        if (checkTaskListIsEmpty) {
            System.out.println("!!!  You don't have any Task  !!!");
            System.out.println("!!! Try command 'task-create' !!!");
        }

        final List<Task> allTask = bootstrap.getTaskService().getAllTaskFromList();
        for (Task task : allTask)
            System.out.println(task.getName());

        System.out.println("[OK]");
    }

    @Override
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return null; }

    @Override
    public String description() { return null; }
}