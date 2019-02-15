package service;

import api.IUserService;
import entity.User;
import repository.UserRepository;

import java.util.List;

public class UserService implements IUserService {
    private UserRepository userRepository;
    public UserService(UserRepository usersRepository) { this.userRepository = usersRepository; }

    public Boolean checkUserListIsEmpty() {
        final List<User> userList = userRepository.getUsersList();
        return userList == null || userList.isEmpty();
    }

    @Override
    public void addUserByList(final User user) {
        if (user == null) return;
        userRepository.addUserByList(user);
    }

    @Override
    public List<User> getUsersList() {
        return userRepository.getUsersList();
    }

    @Override
    public User getUserById (final String userId) {
        if (userId == null) return null;
            User userById = new User();
            final List<User> usersList = userRepository.getUsersList();
            for (User users : usersList)
                if (users.getId().equals(userId))
                    userById = users;
            return userById;
    }
}

