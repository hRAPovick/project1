package by.andersen.test_project.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        SessionFactory localSessionFactory = sessionFactory;
        if (localSessionFactory == null) {
            synchronized (SessionFactory.class) {
                localSessionFactory = sessionFactory;
                if (localSessionFactory == null) {
                    Configuration configuration = new Configuration();
                    configuration.configure("hibernate.cfg.xml");
                    localSessionFactory = configuration.buildSessionFactory();
                    sessionFactory = localSessionFactory;
                }
            }
        }
        return localSessionFactory;
    }
}
