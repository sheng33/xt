package service;

import dao.User;

import javax.servlet.http.HttpSession;

//Service层接口
public interface UserService {

    //检验用户登录
    User checkLogin(String username, String password, HttpSession session);
    void Regist(User user);
}
