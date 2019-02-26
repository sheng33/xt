package controller;


import dao.User;
import dao.UserFile;
import interceptor.LoginInterptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
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
    //任意跳转页面
    @RequestMapping("/anotherpage")
    public String hrefpage(){
        return "anotherpage";
    }
    //注销session
    @RequestMapping("outLogin")
    public String outLogin(HttpSession session){
        session.invalidate();
        return "login";
    }
    @RequestMapping("/regist")
    public String regist(){
        return "regist";
    }
    @RequestMapping("doRegist")
    public String doRegist(User user, Model model){
        userService.Regist(user);
        System.out.println(user.getUsername());
        return "main";
    }
    //处理用户请求的handleRequest方法
    @RequestMapping("/checkLogin")
    public String checkLogin(User user, Model model, HttpSession Session) throws  Exception{
        user = userService.checkLogin(user.getUsername(),user.getPassword(),Session);
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
        List<UserFile> fileList = uploadService.ShowList(user.getRole());
        model.addAttribute("filelist",fileList);
        return "/showAllfile";
    }
}
