package com.gmail.sdima.api;

import com.gmail.sdima.entity.Session;

import java.util.List;

public interface ISessionRepository {
    void addSession(Session session);
    void delete(Session session);
    List<Session> getSessionList();
}
