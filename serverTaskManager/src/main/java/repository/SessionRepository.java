package repository;

import entity.Session;

import java.util.ArrayList;
import java.util.List;

public class SessionRepository {

    private static final int VALID_PERIOD = 1800;

    private List<Session> sessionList = new ArrayList<>();

    public void addSession(final Session session) { sessionList.add(session); }

    public List<Session> getSessionList () { return sessionList; }

    public void delete(final Session session) { sessionList.remove(session); }
}
