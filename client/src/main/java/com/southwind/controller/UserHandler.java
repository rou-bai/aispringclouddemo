package com.southwind.controller;

import com.southwind.entity.User;
import com.southwind.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserFeign userFeign;

    @GetMapping("findall")
    public List<User> findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page - 1) * limit;
        return userFeign.findAll(index, limit);
    };

    @GetMapping("/findbyid/{id}")
    public User findById(@PathVariable("id") Long id){
        return userFeign.findById(id);
    };

    @GetMapping("/count")
    public int count(){
        return userFeign.count();
    };

    @PostMapping("/add")
    public String add(User user){
        userFeign.add(user);
        return "redirect:/user/findall";
    };

    @PutMapping("/update")
    public String update(@RequestBody User user){
        userFeign.update(user);
        return "redirect:/user/findall";
    };

    @DeleteMapping("/deletebyid")
    public String deleteById(Long id){
        userFeign.deleteById(id);
        return "redirect:/user/findall";
    };
}
