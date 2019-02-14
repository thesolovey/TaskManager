package domain;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ConnectionHibernate {
    private static SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration().addAnnotatedClass(entity.User.class).addAnnotatedClass(entity.Session.class).addAnnotatedClass(entity.Project.class).addAnnotatedClass(entity.Task.class).configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }

    public static SessionFactory getSessionFactory() { return sessionFactory; }
}
