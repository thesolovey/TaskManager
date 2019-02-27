package com.gmail.sdima.domain;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static final String PERSISTENT_UNIT_NAME = "pu";
    private static final EntityManagerFactory emf;

    static { emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME); }

    @Produces
    @ApplicationScoped
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
