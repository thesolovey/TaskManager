package api;

import entity.Project;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProjectMapper {

    @Insert("INSERT INTO project (id, name, userName, userLogin, userId) VALUE (#{id}, #{name}, #{userName}, #{userLogin}, #{userId})")
    void addProject(Project project);

    @Select("SELECT * FROM project")
    List<Project> getProjectList();

    @Delete("DELETE FROM project WHERE id=#{id}")
    void deleteProject(Project project);
}
