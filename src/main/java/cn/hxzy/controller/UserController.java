package cn.hxzy.controller;

import cn.hxzy.pojo.User;
import cn.hxzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    public UserService userService;

    //rest风格//  http://localhost:8082/user/1
    @GetMapping("user/{id}")
    @ResponseBody
    public User queryUserById(@PathVariable("id") Long userId){//1 userId
        //alt+回车
        User user=  userService.queryUserById(userId);
        if(user!=null){

            return  user;
        }
        return  null;
    }
    @GetMapping("delete/{id}")
    @ResponseBody
    public String deleteUserById(@PathVariable("id") Long userId){
        userService.deleteUserById(userId);
        return  "ok";
    }

    @GetMapping("/all")
    public String all(Model model){
        List<User> users = userService.queryAll();
        model.addAttribute("users",users);
        return "users";
    }
}
