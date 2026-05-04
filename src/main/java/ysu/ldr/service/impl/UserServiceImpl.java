package ysu.ldr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ysu.ldr.mapper.UserMapper;
import ysu.ldr.pojo.Manager;
import ysu.ldr.pojo.User;
import ysu.ldr.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public List<User> getUserByNameSearch(String userName) {
//        System.out.println("到了service层");
        return userMapper.getUserByNameSearch(userName);
    }

    @Override
    public Integer updateUserStatusById(Integer userId, Boolean commentStatus) {
        return userMapper.updateUserStatusById(userId, commentStatus);
    }

    @Override
    public Integer addUser(User addUser) {
        return userMapper.addUser(addUser);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public Integer deleteUser(Integer userId) {
        return userMapper.deleteUser(userId);
    }

    @Override
    public User getUserById(Integer userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public boolean isLogin(String userName, String password) {
        User user = userMapper.isLogin(userName);
        if(user == null) return false;
        return user.getPassword().equals(password);
    }

    @Override
    public Integer getUserByName(String userName) {
        return userMapper.getIdByName(userName);
    }

    @Override
    public String getUserNameById(Integer userId) {
        return userMapper.getUserNameById(userId);
    }
}
