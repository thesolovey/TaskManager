package com.gmail.sdima9999.bootstrap;

import com.gmail.sdima9999.command.project.ProjectCreateCommand;
import com.gmail.sdima9999.command.project.ProjectDeleteCommand;
import com.gmail.sdima9999.command.project.ProjectListCommand;
import com.gmail.sdima9999.command.project.ProjectUpdateCommand;
import com.gmail.sdima9999.command.task.*;
import com.gmail.sdima9999.readfromconsole.ReadFromConsole;

public class StartTaskManager {
    public static void startManager() {
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
                    ProjectDeleteCommand.execute();
                    break;
                case "task-delete":
                    TaskDeleteCommand.execute();
                    break;
                case "project-update":
                    ProjectUpdateCommand.execute();
                    break;
                case "task-update":
                    TaskUpdateCommand.execute();
                    break;
                case "task-open":
                    TaskOpenCommand.execute();
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
