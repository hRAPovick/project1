package by.andersen.test_project.dao.impl;

import by.andersen.test_project.dao.UserDAO;
import by.andersen.test_project.util.HibernateUtil;
import by.andersen.test_project.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static UserDAOImpl userDAO;

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private UserDAOImpl() {
    }

    public static UserDAO getInstance() {
        UserDAOImpl localUserDAO = userDAO;
        if (localUserDAO == null) {
            synchronized (UserDAOImpl.class) {
                localUserDAO = userDAO;
                if (localUserDAO == null) {
                    localUserDAO = new UserDAOImpl();
                    userDAO = localUserDAO;
                }
            }
        }
        return localUserDAO;
    }

    public void saveUser(User user) {
        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
    }

    public void deleteUser(int id) {
        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            transaction.commit();
        }
    }

    public List<User> findAllUsers() {
        try (Session session = this.sessionFactory.openSession()) {
            return session.createQuery("from User", User.class).list();
        }
    }
}
