package service;

import org.springframework.transaction.annotation.Transactional;
import pojo.User;

import javax.servlet.http.HttpSession;

//Service层接口
@Transactional
public interface UserService {

    //检验用户登录
    User checkLogin(String username, String password, HttpSession session);
    void Regist(User user);
}
