package service;

import api.IUserService;
import entity.User;
import repository.UserRepository;

import javax.persistence.EntityManager;
import java.util.List;

import static domain.HibernateUtil.getEntityManager;

public class UserService implements IUserService {
    private UserRepository userRepository;
    public UserService(UserRepository usersRepository) { this.userRepository = usersRepository; }

    public Boolean checkUserListIsEmpty() {
        final EntityManager manager = getEntityManager();
        userRepository.setManager(manager);
        final List<User> userList = userRepository.getUsersList();
        return userList == null || userList.isEmpty();
    }

    @Override
    public void addUserByList(final User user) {
        if (user == null) return;
        final EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        userRepository.setManager(manager);
        userRepository.addUserByList(user);
        manager.getTransaction().commit();
        manager.close();
        userRepository.setManager(manager);
    }

    @Override
    public List<User> getUsersList() {
        final EntityManager manager = getEntityManager();
        userRepository.setManager(manager);
        return userRepository.getUsersList();
    }

    @Override
    public User getUserById (final String userId) {
        if (userId == null) return null;
            User userById = new User();
            final EntityManager manager = getEntityManager();
            userRepository.setManager(manager);
            final List<User> usersList = userRepository.getUsersList();
            for (User users : usersList)
                if (users.getId().equals(userId))
                    userById = users;
            return userById;
    }
}

