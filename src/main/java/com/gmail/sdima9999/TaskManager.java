package com.gmail.sdima9999;

import com.gmail.sdima9999.command.project.ProjectCreateCommand;
import com.gmail.sdima9999.command.project.ProjectListCommand;
import com.gmail.sdima9999.command.task.TaskCreateCommand;
import com.gmail.sdima9999.command.task.TaskListCommand;

public class TaskManager {
    public static void main(String[] args) {
        System.out.println("***WELLCOME TO TASK MANAGER***");
        Boolean isCorrect = true;
        do {
        String command = ReadFromConsole.readInputFromConsole("Input command: ");
        switch (command) {
            case "project-create":
                ProjectCreateCommand.execute();
                break;
            case "task-create":
                TaskCreateCommand.execute();
                break;
            case "project-list":
                ProjectListCommand.execute();
                break;
            case "task-list":
                TaskListCommand.execute();
                break;
            case "project-delete":
                System.out.println("[PROJECT DELETE]");
                ReadFromConsole.readInputFromConsole("Enter the name of the Project you want to delete: ");
                break;
            case "task-delete":
                System.out.println("[TASK DELETE]");
                ReadFromConsole.readInputFromConsole("Enter the name of the Task you want to delete: ");
                break;
            case "exit":
                isCorrect = false;
                System.out.println("Good bye");
                break;
            default:
                System.out.println("Invalid command");
            }
        } while (isCorrect);
    }
}
