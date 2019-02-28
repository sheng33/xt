package dao;

import org.apache.ibatis.annotations.Param;
import pojo.User;

public interface UserDao {
    User findByUsername(String username);
    /**
     * 注册用户和密码
     */
    void registerByUsernameAndPassword(@Param("username")String username,
                                       @Param("password")String password);

}
