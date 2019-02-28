package controller;


import pojo.User;
import pojo.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UploadService;
import service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private UploadService uploadService;

    private User users;
    //登录界面
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    //跳转到上传页面
    @RequestMapping("file")
    public String uploadfile(Model model,HttpSession session){
        User user = (User)session.getAttribute("user");
        List<UserFile> fileList = uploadService.ShowList(user.getRole());
        model.addAttribute("fileRole",user.getRole());
        model.addAttribute("fileList",fileList);
        return "fileupload";
    }
    //个人信息界面
    @RequestMapping("/person")
    public String person(Model model){
        model.addAttribute("lgn",users.getUsername());
        return "person";
    }
    //任意跳转页面
    @RequestMapping("/anotherpage")
    public String hrefpage(){
        return "anotherpage";
    }
    //注销session
    @RequestMapping("outLogin")
    public String outLogin(HttpSession session){
        session.invalidate();
        return "../index";
    }
    @RequestMapping("/regist")
    public String regist(){
        return "regist";
    }
    @RequestMapping("doRegist")
    public String doRegist(User user, Model model){
        userService.Regist(user);
        return "main";
    }
    //处理用户请求的handleRequest方法
    @RequestMapping("/main")
    public String checkLogin(User user, Model model, HttpSession Session) throws  Exception{
        user = userService.checkLogin(user.getUsername(),user.getPassword(),Session);
        users = user;
        if(user != null){
            model.addAttribute("role",user.getRole());
            model.addAttribute("lgn",user.getUsername());
            return "main";
        }else{
            return "error";
        }
    }

    @RequestMapping("selectAll")
    public String selectAll(Model model,User user){
        System.out.println(users.getRole()+"ssadsa");
        List<UserFile> fileList = uploadService.ShowList(users.getRole());
        model.addAttribute("filelist",fileList);
        return "/showAllfile";
    }
}
