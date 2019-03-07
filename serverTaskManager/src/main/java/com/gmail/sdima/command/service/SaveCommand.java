package com.gmail.sdima.command.service;

//public class SaveCommand extends AbstractCommand {
//
//    public static final String COMMAND = "save";
//
//    public SaveCommand(Bootstrap bootstrap) { super(bootstrap); }
//
//    @Override
//    public void execute() {
//        System.out.println("[SAVE]");
//        try {
//            FileOutputStream fosUser = new FileOutputStream("user.txt");
//            ObjectOutputStream oosUser = new ObjectOutputStream(fosUser);
//            oosUser.writeObject(com.gmail.sdima.bootstrap.getiUserService().getUsersList());
//            oosUser.flush();
//            oosUser.close();
//
//            FileOutputStream fosProject = new FileOutputStream("project.txt");
//            ObjectOutputStream oosProject = new ObjectOutputStream(fosProject);
////            oosProject.writeObject(com.gmail.sdima.bootstrap.getProjectService().getProjectByUserId());
//            oosProject.flush();
//            oosProject.close();
//
//            FileOutputStream fosTask = new FileOutputStream("task.txt");
//            ObjectOutputStream oosTask = new ObjectOutputStream(fosTask);
////            oosTask.writeObject(com.gmail.sdima.bootstrap.getiTaskService().getTaskByUserId());
//            oosTask.flush();
//            oosTask.close();
//        } catch (IOException e) {e.printStackTrace();}
//
//        System.out.println("[OK]");
//    }
//}
