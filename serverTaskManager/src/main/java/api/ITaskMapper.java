package api;

import entity.Task;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITaskMapper {

    @Insert("INSERT INTO task (id, name, nameByProject, idByProject, userLogin, idByUser, dateBegin, dateEnd) VALUE (#{id}, #{name}, #{nameByProject}, #{idByProject}, #{userLogin}, #{idByUser}, #{dateBegin}, #{dateEnd})")
    void addTask(Task task);

    @Select("SELECT * FROM task")
    List<Task> getTaskList();

    @Delete("DELETE FROM task WHERE id = #{id}")
    void deleteTask(Task task);
}
