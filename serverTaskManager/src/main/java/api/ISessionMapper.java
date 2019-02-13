package api;

import entity.Session;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISessionMapper {

    @Insert("INSERT INTO session (userId, signature, startValidPeriod) VALUE (#{userId}, #{signature}, #{startValidPeriod})")
    void addSession(Session session);

    @Select("SELECT * FROM session")
    List<Session> getSessionList();

    @Delete("DELETE FROM session WHERE userId=#{userId}")
    void delete(Session session);
}
