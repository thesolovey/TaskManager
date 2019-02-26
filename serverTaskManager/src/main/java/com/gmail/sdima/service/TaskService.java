package com.gmail.sdima.service;

import com.gmail.sdima.api.ITaskService;
import com.gmail.sdima.dto.TaskDTO;
import com.gmail.sdima.entity.Project;
import com.gmail.sdima.entity.Session;
import com.gmail.sdima.entity.Task;
import com.gmail.sdima.repository.TaskRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static com.gmail.sdima.domain.HibernateUtil.getEntityManager;

@ApplicationScoped
public class TaskService implements ITaskService {

    @Inject TaskRepository taskRepository;

    @Override
    public boolean checkTaskListIsEmpty() {
        final EntityManager manager = getEntityManager();
        taskRepository.setManager(manager);
        final List<Task> taskList = taskRepository.getTaskList();
        return taskList == null || taskList.isEmpty();
    }

    @Override
    public void addTask(final TaskDTO taskDTO, final Project project) {
        if (taskDTO == null) return;
        final Task task = new Task();
        task.setId(taskDTO.getId());
        task.setName(taskDTO.getName());
        task.setProject(project);
        task.setUserLogin(taskDTO.getUserLogin());
        task.setIdByUser(taskDTO.getIdByUser());
        task.setDateBegin(taskDTO.getDateBegin());
        task.setDateEnd(taskDTO.getDateEnd());
        final EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        taskRepository.setManager(manager);
        taskRepository.addTask(task);
        manager.getTransaction().commit();
        manager.close();
        taskRepository.setManager(manager);
    }

    @Override
    public List<String> getTaskByUserId(final Session session) {
        if (session == null) return null;
        final EntityManager manager = getEntityManager();
        taskRepository.setManager(manager);
        final List<Task> taskList = taskRepository.getTaskList();
        final List<String> taskListByUserId = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getIdByUser().equals(session.getUserId()))
                taskListByUserId.add(task.getName());
        }
        return taskListByUserId;
    }

    @Override
    public List<String> getTaskByProjectName(final String projectName) {
        if (projectName == null) return null;
        final EntityManager manager = getEntityManager();
        taskRepository.setManager(manager);
        final List<Task> taskList = taskRepository.getTaskList();
        final List<String> taskByProjectName = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getProject().getName().equals(projectName))
                taskByProjectName.add(task.getName());
        }
        return taskByProjectName;
    }

    @Override
    public void deleteTaskByProjectId(final String projectId) {
        if (projectId == null) return;
        final EntityManager manager = getEntityManager();
        taskRepository.setManager(manager);
        final List<Task> taskList = taskRepository.getTaskList();
        Task taskForDelete = new Task();
        if (taskList == null || taskList.isEmpty()) return;
        for (Task task : taskList)
            if (task.getProject().getId().equals(projectId)) {
                taskForDelete = task;
                manager.getTransaction().begin();
                taskRepository.setManager(manager);
                taskRepository.deleteTask(taskForDelete);
                manager.getTransaction().commit();
                manager.close();
                taskRepository.setManager(manager);
            }
    }

    @Override
    public List<Task> openTaskByName(final String nameTask) {
        if (nameTask == null) return null;
        final EntityManager manager = getEntityManager();
        taskRepository.setManager(manager);
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
        final EntityManager manager = getEntityManager();
        taskRepository.setManager(manager);
        final List<Task> taskList = taskRepository.getTaskList();
        for (Task task : taskList) {
            if (task.getId().equals(idTask)) {
                manager.getTransaction().begin();
                taskRepository.setManager(manager);
                taskRepository.deleteTask(task);
                manager.getTransaction().commit();
                manager.close();
                taskRepository.setManager(manager);
                return;
            }
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

