package com.gmail.sdima9999.command.task;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.entity.Task;

import java.util.List;

public class TaskListCommand extends AbstractCommand {
    public TaskListCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public void execute() {
        System.out.println("[TASK LIST]");

        boolean checkTaskListIsEmpty = bootstrap.getTaskService().checkTaskListIsEmpty();
        if (checkTaskListIsEmpty) {
            System.out.println("!!!  You don't have any Task  !!!");
            System.out.println("!!! Try command 'task-create' !!!");
        }

        List<Task> allTask = bootstrap.getTaskService().getAllNameTaskFromList();
        for (Task task : allTask)
            System.out.println(task.getName());

        System.out.println("[OK]");
    }

    @Override
    public void secure() {

    }
}
