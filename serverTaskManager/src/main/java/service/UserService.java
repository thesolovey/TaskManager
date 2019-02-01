package service;

import api.IUserService;
import entity.User;
import repository.UserRepository;

import java.util.List;

public class UserService implements IUserService {
    private UserRepository usersRepository;
    public UserService(UserRepository usersRepository) { this.usersRepository = usersRepository; }

//    private User currentUser = null;
//    public User getCurrentUser() { return currentUser; }
//    public void setCurrentUser(User currentUser) { this.currentUser = currentUser; }
//    private Session currentSession = null;
//    public Session getUserSession() { return currentSession; }
//    public void setUserSession(Session userSession) { this.currentSession = userSession; }
//
//    public boolean isAuth() { return currentSession != null; }
//    public void logOut() { currentSession = null; }


    public Boolean checkUserListIsEmpty() {
        List<User> usersList = usersRepository.getUsersList();
        return usersList == null || usersList.isEmpty();
    }

    public void addUserByList(User user) {
        if (user == null) return;
        usersRepository.addUser(user);
    }

    public List<User> getUsersList() { return usersRepository.getUsersList(); }

    public User getUserById (String userId) {
        User userById = new User();
        final List<User> usersList = usersRepository.getUsersList();
        for (User users : usersList)
            if (users.getId().equals(userId))
                userById = users;
                return userById;
    }

    public void clearUsersList() {
        usersRepository.clearUsersList(); }

    public void addListUsers(List<User> userList) {
        if (userList == null) return;
        usersRepository.addListUser(userList);
    }
}

