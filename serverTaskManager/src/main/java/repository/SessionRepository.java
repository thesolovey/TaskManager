package repository;

import entity.Session;

import java.util.ArrayList;
import java.util.List;

public class SessionRepository {
    private List<Session> sessionList = new ArrayList<>();

    public void addSession(Session session) { sessionList.add(session); }

    public void deleteSession(Session session) {sessionList.remove(session); }

    public List<Session> getSessionList() { return sessionList; }
}
