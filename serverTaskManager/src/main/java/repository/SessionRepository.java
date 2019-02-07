package repository;

import entity.Session;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class SessionRepository extends AbstractRepository {
    public SessionRepository(Connection connection) { this.connection = connection; }

    private final List<Session> sessionList = new ArrayList<>();

    public void addSession(final Session session) { sessionList.add(session); }

    public void delete(final Session session) { sessionList.remove(session); }

    public List<Session> getSessionList () { return sessionList; }
}
