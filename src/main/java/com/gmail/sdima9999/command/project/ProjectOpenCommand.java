package com.gmail.sdima9999.command.project;

import com.gmail.sdima9999.readfromconsole.ReadFromConsole;
import com.gmail.sdima9999.repository.ProjectRepository;

public class ProjectOpenCommand {
    public static void execute () {
        System.out.println("[PROJECT OPEN]");
        String name = ReadFromConsole.readInputFromConsole("Enter name Project do you want open: ");
        ProjectRepository.openProject(name);
        System.out.println("[OK]");
    }
}
