package ysu.ldr.service;

import ysu.ldr.pojo.User;

import java.util.List;

public interface UserService {
    //获取所有用户
    public List<User> getAllUser();

    //更具用户名模糊搜索用户信息
    public List<User> getUserByNameSearch(String userName);

    public Integer updateUserStatusById(Integer userId, Boolean commentStatus);

    public Integer addUser(User addUser);

    public Integer updateUser(User user);

    public Integer deleteUser(Integer userId);

    public User getUserById(Integer userId);

    public boolean isLogin(String userName, String password);

    public Integer getUserByName(String userName);

    public String getUserNameById(Integer userId);
}
