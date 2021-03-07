package com.southwind.controller;

import com.southwind.entity.User;
import com.southwind.entity.UserVO;
import com.southwind.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserFeign userFeign;

    @GetMapping("/index")
    public String index(){
        return "user_manage";
    }

    @GetMapping("/findall")
    @ResponseBody
    public UserVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page - 1) * limit;
        return userFeign.findAll(index, limit);
    };

    @GetMapping("/info/{id}")
    public String findById(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userFeign.findById(id));
        return "user_update";
    };

    @GetMapping("/count")
    public int count(){
        return userFeign.count();
    };

    @PostMapping("/add")
    public String add(User user){
        System.out.println(user);
        userFeign.add(user);
        return "redirect:/user/index";
    };

    @GetMapping("/info/add")
    public String infoAdd(){
        return "user_add";
    }

    @PostMapping("/update")
    public String update(User user){
        userFeign.update(user);
        return "redirect:/user/index";
    };

    @GetMapping("/deletebyid/{id}")
    public String deleteById(@PathVariable("id") Long id){
        userFeign.deleteById(id);
        return "redirect:/user/index";
    };
}
