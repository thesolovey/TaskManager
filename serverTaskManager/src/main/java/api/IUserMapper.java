package api;

import entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserMapper {

    @Insert("INSERT INTO user (id, login, password, userName) VALUE (#{id}, #{login}, #{password}, #{userName})")
    void addUserByList(User user);

    @Select("SELECT * FROM user")
    List<User> getUsersList();

    @Delete("DELETE FROM user WHERE id = #{user}")
    void delete(User user);
}
