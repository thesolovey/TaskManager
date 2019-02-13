package service;

import api.IUserMapper;
import api.IUserService;
import domain.ConnectionMybatis;
import entity.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserService implements IUserService {
//    private UserRepository usersRepository;
//    public UserService(UserRepository usersRepository) { this.usersRepository = usersRepository; }

    public Boolean checkUserListIsEmpty() {
        SqlSession session = ConnectionMybatis.getSqlSessionFactory().openSession();
        try {
            IUserMapper userMapper = session.getMapper(IUserMapper.class);
            final List<User> usersList = userMapper.getUsersList();
            return usersList == null || usersList.isEmpty();
        } finally {
            session.close();
        }
    }

    public void addUserByList(final User user) {
        if (user == null) return;
//        usersRepository.addUser(user);

        SqlSession session = ConnectionMybatis.getSqlSessionFactory().openSession();
        try {
            IUserMapper userMapper = session.getMapper(IUserMapper.class);
            userMapper.addUserByList(user);
            session.commit();
        } finally {
            session.close();
        }
    }

    public List<User> getUsersList() {
//        return usersRepository.getUsersList(); }
        SqlSession session = ConnectionMybatis.getSqlSessionFactory().openSession();
        try {
            IUserMapper userMapper = session.getMapper(IUserMapper.class);
            return userMapper.getUsersList();
        } finally {
            session.close();
        }
        }

    public User getUserById (final String userId) {
        SqlSession session = ConnectionMybatis.getSqlSessionFactory().openSession();
        try {
            User userById = new User();
            IUserMapper userMapper = session.getMapper(IUserMapper.class);
            final List<User> usersList = userMapper.getUsersList();
            for (User users : usersList)
                if (users.getId().equals(userId))
                    userById = users;
            return userById;
        } finally {
            session.close();
        }
    }

    public void clearUsersList() {
//       usersRepository.clearUsersList(); }
}
}

