package com.gmail.sdima9999.command.project;

import com.gmail.sdima9999.readfromconsole.ReadFromConsole;
import com.gmail.sdima9999.repository.ProjectRepository;

public class ProjectDeleteCommand {
    public static void execute() {
        System.out.println("[PROJECT DELETE]");
        String name = ReadFromConsole.readInputFromConsole("Enter the name of the Project you want to delete: ");
        if (ProjectRepository.projectList.contains(name)) {
            ProjectRepository.removeProjectList(name);
            System.out.println("[ОК]");
        } else System.out.println("Invalid name of Project");
    }
}
