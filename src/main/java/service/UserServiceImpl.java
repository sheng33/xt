package service;

import dao.UserDao;
import dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    public User checkLogin(String username, String password, HttpSession session){
        User user = userDao.findByUsername(username);
        if(user != null && user.getPassword().equals(password)){
            session.setAttribute("user",user);
            return user;
        }
        return null;
    }

    @Override
    public void Regist(User user){
        userDao.registerByUsernameAndPassword (user.getUsername(),user.getPassword());
    }
}
