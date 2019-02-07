package service;

import api.ITaskService;
import entity.Session;
import entity.Task;
import repository.ProjectRepository;
import repository.TaskRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TaskService implements ITaskService {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public TaskService(TaskRepository taskRepository, ProjectRepository projectRepository) { this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    public boolean checkTaskListIsEmpty() {
        List<Task> taskList = taskRepository.getTaskList();
        return taskList == null || taskList.isEmpty();
    }

    public void addTask(Task task) {
        if (taskRepository.getTaskList() == null) return;
        taskRepository.addTask(task);
    }

    public List<Task> getTaskByUserId(Session session) {
        final List<Task> taskList = taskRepository.getTaskList();
        final List<Task> taskListByUserId = new ArrayList<>();
        for (Task task: taskList)
            if (task.getIdByUser().equals(session.getUserId()))
                taskListByUserId.add(task);
        return taskListByUserId;
    }

    public List<Task> getTaskByProjectName(String projectName) {
        final List<Task> taskList = taskRepository.getTaskList();
        final List<Task> taskByProjectName = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getNameByProject().equals(projectName))
                taskByProjectName.add(task);
        } return taskByProjectName;
    }

    public void deleteTaskByProjectId(String projectId) {
        if (projectId == null) return;
        final List<Task> taskList = taskRepository.getTaskList();
        if (taskList == null || taskList.isEmpty()) return;
        Iterator<Task> it = taskList.iterator(); it.hasNext();
        Task task = it.next();
        if (task.getIdByProject().equals(projectId))
            it.remove();
    }

    public List<Task> openTaskByName(String nameTask) {
        final List<Task> taskList = taskRepository.getTaskList();
        final List<Task> taskListByName = new ArrayList<>();
        for (Task task : taskList)
            if (task.getName().equals(nameTask))
                taskListByName.add(task);
        return taskListByName;
    }

    public void clearTaskList() {
        taskRepository.clearTaskList();
    }

    public void deleteTask(String idTask) {
        if (idTask == null) return;
        final List<Task> taskList = taskRepository.getTaskList();
        for (Task task : taskList) {
            if (task.getId().equals(idTask)) {
                taskRepository.deleteTask(task);
                return;
            }
        }
    }

    public void updateTask(String name, String newName, Date newDateEnd) {
        if (taskRepository.getTaskList() == null) return;
        final List<Task> taskList = taskRepository.getTaskList();
        for (Task task : taskList)
            if (task.getName().equals(name)) {
                task.setName(newName);
                task.setDateEnd(newDateEnd);
            }
    }

    public void addListTasks(List<Task> tasks) {
        if (tasks == null) return;
        taskRepository.addListTasks(tasks);
    }
}

