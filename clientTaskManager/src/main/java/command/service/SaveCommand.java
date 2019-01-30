package command.service;

import bootstrap.BootstrapClient;
import command.AbstractCommand;

public class SaveCommand extends AbstractCommand {

    public SaveCommand(BootstrapClient bootstrap) { super(bootstrap); }
    public static final String COMMAND = "save";

    @Override
    public void execute() {
//        System.out.println("[SAVE]");
//        try {
//            FileOutputStream fosUser = new FileOutputStream("user.txt");
//            ObjectOutputStream oosUser = new ObjectOutputStream(fosUser);
//            oosUser.writeObject(bootstrap.getUserService().getUsersList());
//            oosUser.flush();
//            oosUser.close();
//
//            FileOutputStream fosProject = new FileOutputStream("project.txt");
//            ObjectOutputStream oosProject = new ObjectOutputStream(fosProject);
//            oosProject.writeObject(bootstrap.getProjectService().getAllProjectFromList());
//            oosProject.flush();
//            oosProject.close();
//
//            FileOutputStream fosTask = new FileOutputStream("task.txt");
//            ObjectOutputStream oosTask = new ObjectOutputStream(fosTask);
//            oosTask.writeObject(bootstrap.getTaskService().getAllTaskFromList());
//            oosTask.flush();
//            oosTask.close();
//        } catch (IOException e) {e.printStackTrace();}
//
//        System.out.println("[OK]");
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
        return "Save data";
    }
}
