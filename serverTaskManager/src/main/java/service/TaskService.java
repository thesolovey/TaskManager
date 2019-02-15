package service;

import api.ITaskService;
import entity.Session;
import entity.Task;
import repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class TaskService implements ITaskService {
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) { this.taskRepository = taskRepository;
    }

    @Override
    public boolean checkTaskListIsEmpty() {
        final List<Task> taskList = taskRepository.getTaskList();
        return taskList == null || taskList.isEmpty();
    }

    @Override
    public void addTask(final Task task) {
        if (task == null) return;
        taskRepository.addTask(task);
    }

    @Override
    public List<Task> getTaskByUserId(final Session session) {
        if (session == null) return null;
        final List<Task> taskList = taskRepository.getTaskList();
        final List<Task> taskListByUserId = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getIdByUser().equals(session.getUserId()))
                taskListByUserId.add(task);
        }
            return taskListByUserId;
    }

    @Override
    public List<Task> getTaskByProjectName(final String projectName) {
        if (projectName == null) return null;
        final List<Task> taskList = taskRepository.getTaskList();
        final List<Task> taskByProjectName = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getNameByProject().equals(projectName))
                taskByProjectName.add(task);
            }
            return taskByProjectName;
    }

    @Override
    public void deleteTaskByProjectId(final String projectId) {
        if (projectId == null) return;
            final List<Task> taskList = taskRepository.getTaskList();
            Task taskForDelete = new Task();
            if (taskList == null || taskList.isEmpty()) return;
            for (Task task : taskList)
                if (task.getIdByProject().equals(projectId)) {
                    taskForDelete = task;
                    taskRepository.deleteTask(taskForDelete);
                }
    }

    @Override
    public List<Task> openTaskByName(final String nameTask) {
        if (nameTask == null) return null;
        final List<Task> taskList = taskRepository.getTaskList();
        final List<Task> taskListByName = new ArrayList<>();
        for (Task task : taskList)
            if (task.getName().equals(nameTask))
                taskListByName.add(task);
            return taskListByName;
    }

    @Override
    public void deleteTask(final String idTask) {
        if (idTask == null) return;
        final List<Task> taskList = taskRepository.getTaskList();
        for (Task task : taskList) {
            if (task.getId().equals(idTask)) {
                taskRepository.deleteTask(task);
                return;
                }
            }
        }

//    public void updateTask(String name, String newName, Date newDateEnd) {
//        if (taskRepository.getTaskList() == null) return;
//        final List<Task> taskList = taskRepository.getTaskList();
//        for (Task task : taskList)
//            if (task.getName().equals(name)) {
//                task.setName(newName);
//                task.setDateEnd(newDateEnd);
//            }
//    }
}

