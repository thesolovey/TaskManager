package com.gmail.sdima9999.command.project;

import com.gmail.sdima9999.repository.ProjectRepository;

public class ProjectListCommand {
    public static void execute() {
        System.out.println("[PROJECT LIST]");
        ProjectRepository.getProjectList();
        System.out.println("[OK]");
    }
}