package service;

import api.ITaskHibernate;
import api.ITaskService;
import entity.Session;
import entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

import static domain.HibernateUtil.getEntityManager;

public class TaskService implements ITaskService, ITaskHibernate {

    public boolean checkTaskListIsEmpty() {
        final EntityManager manager = getEntityManager();
        try {
            TypedQuery<Task> namedQuery = manager.createNamedQuery("Task.getAll", Task.class);
            final List<Task> taskList = namedQuery.getResultList();
            return taskList == null || taskList.isEmpty();
        } finally {
            manager.close();
        }
    }

    public void addTask(final Task task) {
        if (task == null) return;
        final EntityManager manager = getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(task);
            manager.getTransaction().commit();
        } finally {
            manager.close();
        }
    }

    public List<Task> getTaskByUserId(final Session session) {
        if (session == null) return null;
        final EntityManager manager = getEntityManager();
        try {
            TypedQuery<Task> namedQuery = manager.createNamedQuery("Task.getAll", Task.class);
            final List<Task> taskList = namedQuery.getResultList();
            final List<Task> taskListByUserId = new ArrayList<>();
            for (Task task : taskList)
                if (task.getIdByUser().equals(session.getUserId()))
                    taskListByUserId.add(task);
            return taskListByUserId;
        } finally {
            manager.close();
        }
    }

    public List<Task> getTaskByProjectName(final String projectName) {
        if (projectName == null) return null;
        final EntityManager manager = getEntityManager();
        try {
            TypedQuery<Task> namedQuery = manager.createNamedQuery("Task.getAll", Task.class);
            final List<Task> taskList = namedQuery.getResultList();
            final List<Task> taskByProjectName = new ArrayList<>();
            for (Task task : taskList) {
                if (task.getNameByProject().equals(projectName))
                    taskByProjectName.add(task);
            }
            return taskByProjectName;
        } finally {
            manager.close();
        }
    }

    public void deleteTaskByProjectId(final String projectId) {
        if (projectId == null) return;
        final EntityManager manager = getEntityManager();
        try {
            manager.getTransaction().begin();
            TypedQuery<Task> namedQuery = manager.createNamedQuery("Task.getAll", Task.class);
            final List<Task> taskList = namedQuery.getResultList();
            Task taskForDelete = new Task();
            if (taskList == null || taskList.isEmpty()) return;
            for (Task task : taskList)
                if (task.getIdByProject().equals(projectId)) {
                    taskForDelete = task;
                    manager.remove(taskForDelete);
                }
        } finally {
            manager.getTransaction().commit();
            manager.close();
        }
    }

    public List<Task> openTaskByName(final String nameTask) {
        if (nameTask == null) return null;
        final EntityManager manager = getEntityManager();
        try {
            TypedQuery<Task> namedQuery = manager.createNamedQuery("Task.getAll", Task.class);
            final List<Task> taskList = namedQuery.getResultList();
            final List<Task> taskListByName = new ArrayList<>();
            for (Task task : taskList)
                if (task.getName().equals(nameTask))
                    taskListByName.add(task);
            return taskListByName;
        } finally {
            manager.close();
        }
    }

    public void deleteTask(final String idTask) {
        if (idTask == null) return;
        final EntityManager manager = getEntityManager();
        try {
            manager.getTransaction().begin();
            TypedQuery<Task> namedQuery = manager.createNamedQuery("Task.getAll", Task.class);
            final List<Task> taskList = namedQuery.getResultList();
            for (Task task : taskList) {
                if (task.getId().equals(idTask)) {
                    manager.remove(task);
                    manager.getTransaction().commit();
                    return;
                }
            }
        } finally {
            manager.close();
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

