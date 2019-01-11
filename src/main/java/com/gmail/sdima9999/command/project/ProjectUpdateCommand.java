package com.gmail.sdima9999.command.project;

import com.gmail.sdima9999.ReadFromConsole;
import com.gmail.sdima9999.repository.ProjectRepository;

public class ProjectUpdateCommand {
    public static void execute() {
        System.out.println("[PROJECT UPDATE]");
        String name = ReadFromConsole.readInputFromConsole("Enter the name of the Project you want to exchange: ");
        if (ProjectRepository.myProjectList.contains(name)) {
            ProjectRepository.changeProjectList(name, ReadFromConsole.readInputFromConsole("Enter new name: "));
            System.out.println("[OK]");
        } else System.out.println("Invalid name of Project");
    }
}
