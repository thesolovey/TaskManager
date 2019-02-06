package command.service;

import bootstrap.Bootstrap;
import command.AbstractCommand;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCommand extends AbstractCommand {

    public static final String COMMAND = "save";

    public SaveCommand(Bootstrap bootstrap) { super(bootstrap); }

    @Override
    public void execute() {
        System.out.println("[SAVE]");
        try {
            FileOutputStream fosUser = new FileOutputStream("user.txt");
            ObjectOutputStream oosUser = new ObjectOutputStream(fosUser);
            oosUser.writeObject(bootstrap.getiUserService().getUsersList());
            oosUser.flush();
            oosUser.close();

            FileOutputStream fosProject = new FileOutputStream("project.txt");
            ObjectOutputStream oosProject = new ObjectOutputStream(fosProject);
//            oosProject.writeObject(bootstrap.getProjectService().getProjectByUserId());
            oosProject.flush();
            oosProject.close();

            FileOutputStream fosTask = new FileOutputStream("task.txt");
            ObjectOutputStream oosTask = new ObjectOutputStream(fosTask);
//            oosTask.writeObject(bootstrap.getiTaskService().getAllTaskFromList());
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
        return "save";
    }

    @Override
    public String description() {
        return "Save Project and Task";
    }
}
