package api;

import entity.User;

import java.util.List;

public interface IUserService{
    void addUserByList(User user);
    List<User> getUsersList();
    User getUserById(String userId);
}
