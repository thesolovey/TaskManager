package com.gmail.sdima.command.service;

import com.gmail.sdima.bootstrap.Bootstrap;
import com.gmail.sdima.command.AbstractCommand;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCommand extends AbstractCommand {

    public SaveCommand(Bootstrap bootstrap) { super(bootstrap); }
    public static final String COMMAND = "save";

    @Override
    public void execute() {
        System.out.println("[SAVE]");
        try {
            FileOutputStream fosUser = new FileOutputStream("user.txt");
            ObjectOutputStream oosUser = new ObjectOutputStream(fosUser);
            oosUser.writeObject(bootstrap.getUserService().getUsersList());
            oosUser.flush();
            oosUser.close();

            FileOutputStream fosProject = new FileOutputStream("project.txt");
            ObjectOutputStream oosProject = new ObjectOutputStream(fosProject);
            oosProject.writeObject(bootstrap.getProjectService().getAllProjectFromList());
            oosProject.flush();
            oosProject.close();

            FileOutputStream fosTask = new FileOutputStream("task.txt");
            ObjectOutputStream oosTask = new ObjectOutputStream(fosTask);
            oosTask.writeObject(bootstrap.getTaskService().getAllTaskFromList());
            oosTask.flush();
            oosTask.close();
        } catch (IOException e) {e.printStackTrace();}

        System.out.println("[OK]");
    }

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public String getKeyWord() {
        return null;
    }

    @Override
    public String description() {
        return null;
    }
}
