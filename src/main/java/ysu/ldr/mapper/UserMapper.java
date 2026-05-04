package ysu.ldr.mapper;

import org.apache.ibatis.annotations.Param;
import ysu.ldr.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> getAllUser();

    public List<User> getUserByNameSearch(String userName);

    public Integer updateUserStatusById(@Param("userId") Integer userId, @Param("commentStatus") Boolean commentStatus);

    public Integer addUser(User addUser);

    public Integer updateUser(User user);

    public Integer deleteUser(Integer userId);

    public User getUserById(@Param("userId") Integer userId);

    public User isLogin(@Param("userName") String userName);

    public Integer getIdByName(String userName);

    public String getUserNameById(Integer userId);
}
