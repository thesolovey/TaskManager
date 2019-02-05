package service;

import api.IUserService;
import entity.User;
import repository.UserRepository;

import java.util.List;

public class UserService implements IUserService {
    private UserRepository usersRepository;
    public UserService(UserRepository usersRepository) { this.usersRepository = usersRepository; }

    public Boolean checkUserListIsEmpty() {
        List<User> usersList = usersRepository.getUsersList();
        return usersList == null || usersList.isEmpty();
    }

    public void addUserByList(final User user) {
        if (user == null) return;
        usersRepository.addUser(user);
    }

    public List<User> getUsersList() {
        return usersRepository.getUsersList(); }

    public User getUserById (final String userId) {
        User userById = new User();
        final List<User> usersList = usersRepository.getUsersList();
        for (User users : usersList)
            if (users.getId().equals(userId))
                userById = users;
                return userById;
    }

    public void clearUsersList() {
        usersRepository.clearUsersList(); }

    public void addListUsers(final List<User> userList) {
        if (userList == null) return;
        usersRepository.addListUser(userList);
    }
}

