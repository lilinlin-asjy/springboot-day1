package com.asjy.controller;

import com.asjy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.asjy.po.User;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: lilinlin
 * @Date: 2021/4/14
 * @Description: com.asjy.controller
 * @version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/userList")
     public String userList(Model mode){
        mode.addAttribute("name","tom");
        User user = new User("jerry",18);
        mode.addAttribute("user",user);
        List<User> userList = new ArrayList<>();
        userList.add(new User("张三",10));
        userList.add(new User("李四",11));
        userList.add(new User("王五",12));
        mode.addAttribute("users",userList);

        return "userList";
    }

    @RequestMapping("/getAllUser")
    public String getAllUser(Model model){
        model.addAttribute("name","tom");
        User user = new User("jerry",18);
        model.addAttribute("user",user);
        List<User> userList = userService.getAllUser();
        model.addAttribute("users",userList);
        return "addUser";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Map<String, Object> addUser(@Valid User user, BindingResult bindingResult){
        Map<String, Object> map = new HashMap<String, Object>();
        if (bindingResult.hasErrors()) {
            List<ObjectError> errorList = bindingResult.getAllErrors();
            List<String> mesList=new ArrayList<String>();
            for (int i = 0; i < errorList.size(); i++) {
                mesList.add(errorList.get(i).getDefaultMessage());
            }
            System.out.println("sdf");
            map.put("status", false);
            map.put("error", mesList);
        } else {
            map.put("status", true);
            map.put("msg", "添加成功");
        }
        return map;

    }


}