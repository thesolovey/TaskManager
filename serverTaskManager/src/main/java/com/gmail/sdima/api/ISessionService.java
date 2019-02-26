package com.gmail.sdima.api;

import com.gmail.sdima.entity.Session;
import com.gmail.sdima.exception.AccessForbiddenException;

public interface ISessionService {
    void validateSession(Session session) throws AccessForbiddenException;
    void logOut(Session session);
    Session getNewSession(String userId);
    Session getSessionById(String userId);

}
