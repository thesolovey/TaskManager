package service;

import api.ITaskMapper;
import api.ITaskService;
import domain.ConnectionMybatis;
import entity.Session;
import entity.Task;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskService implements ITaskService {
//    private final TaskRepository taskRepository;
//    private final ProjectRepository projectRepository;
//
//    public TaskService(TaskRepository taskRepository, ProjectRepository projectRepository) { this.taskRepository = taskRepository;
//        this.projectRepository = projectRepository;
//    }

    public boolean checkTaskListIsEmpty() {
        SqlSession sqlSession = ConnectionMybatis.getSqlSessionFactory().openSession();
        try {
            ITaskMapper taskMapper = sqlSession.getMapper(ITaskMapper.class);
            final List<Task> taskList = taskMapper.getTaskList();
            return taskList == null || taskList.isEmpty();
        } finally {
            sqlSession.close();
        }
    }

    public void addTask(Task task) {
        if (task == null) return;
        SqlSession sqlSession = ConnectionMybatis.getSqlSessionFactory().openSession();
        try {
            ITaskMapper taskMapper = sqlSession.getMapper(ITaskMapper.class);
            taskMapper.addTask(task);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public List<Task> getTaskByUserId(Session session) {
        if (session == null) return null;
        SqlSession sqlSession = ConnectionMybatis.getSqlSessionFactory().openSession();
        try {
            ITaskMapper taskMapper = sqlSession.getMapper(ITaskMapper.class);
            final List<Task> taskList = taskMapper.getTaskList();
            final List<Task> taskListByUserId = new ArrayList<>();
            for (Task task : taskList)
                if (task.getIdByUser().equals(session.getUserId()))
                    taskListByUserId.add(task);
            return taskListByUserId;
        } finally {
            sqlSession.close();
        }
    }

    public List<Task> getTaskByProjectName(String projectName) {
        if (projectName == null) return null;
        SqlSession sqlSession = ConnectionMybatis.getSqlSessionFactory().openSession();
        try {
            ITaskMapper taskMapper = sqlSession.getMapper(ITaskMapper.class);
            final List<Task> taskList = taskMapper.getTaskList();
            final List<Task> taskByProjectName = new ArrayList<>();
            for (Task task : taskList) {
                if (task.getNameByProject().equals(projectName))
                    taskByProjectName.add(task);
            }
            return taskByProjectName;
        } finally {
            sqlSession.close();
        }
    }

    public void deleteTaskByProjectId(String projectId) {
        if (projectId == null) return;
        SqlSession sqlSession = ConnectionMybatis.getSqlSessionFactory().openSession();
        try {
            ITaskMapper taskMapper = sqlSession.getMapper(ITaskMapper.class);
            final List<Task> taskList = taskMapper.getTaskList();
            Task taskForDelete = new Task();
            if (taskList == null || taskList.isEmpty()) return;
            for (Task task : taskList)
                if (task.getIdByProject().equals(projectId)) {
                    taskForDelete = task;
                    taskMapper.deleteTask(taskForDelete);
                    sqlSession.commit();
                }
//        Iterator<Task> it = taskList.iterator(); it.hasNext();
//        Task task = it.next();
//        if (task.getIdByProject().equals(projectId))
//            it.remove();
        } finally {
            sqlSession.close();
        }
    }

    public List<Task> openTaskByName(String nameTask) {
        if (nameTask == null) return null;
        SqlSession sqlSession = ConnectionMybatis.getSqlSessionFactory().openSession();
        try {
            ITaskMapper taskMapper = sqlSession.getMapper(ITaskMapper.class);
            final List<Task> taskList = taskMapper.getTaskList();
            final List<Task> taskListByName = new ArrayList<>();
            for (Task task : taskList)
                if (task.getName().equals(nameTask))
                    taskListByName.add(task);
            return taskListByName;
        } finally {
            sqlSession.close();
        }
    }

    public void deleteTask(String idTask) {
        if (idTask == null) return;
        SqlSession sqlSession = ConnectionMybatis.getSqlSessionFactory().openSession();
        try {
            ITaskMapper taskMapper = sqlSession.getMapper(ITaskMapper.class);
            final List<Task> taskList = taskMapper.getTaskList();
            for (Task task : taskList) {
                if (task.getId().equals(idTask)) {
                    taskMapper.deleteTask(task);
                    sqlSession.commit();
                    return;
                }
            }
        } finally {
            sqlSession.close();
        }
    }

    public void clearTaskList() {
//        taskRepository.clearTaskList();
    }

    public void updateTask(String name, String newName, Date newDateEnd) {
//        if (taskRepository.getTaskList() == null) return;
//        final List<Task> taskList = taskRepository.getTaskList();
//        for (Task task : taskList)
//            if (task.getName().equals(name)) {
//                task.setName(newName);
//                task.setDateEnd(newDateEnd);
//            }
    }
}

