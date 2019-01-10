package com.gmail.sdima9999.command.project;

import com.gmail.sdima9999.ReadFromConsole;
import com.gmail.sdima9999.entity.Project;
import com.gmail.sdima9999.repository.ProjectRepository;

public class ProjectCreateCommand {
    public static void execute() {
        System.out.println("[PROJECT CREATE]");
        Project project = new Project();
        project.setName(ReadFromConsole.readInputFromConsole("Input name Project: "));
        ProjectRepository.projectListAdd(project.getName());
        System.out.println("[OK]");
    }
}
