package com.southwind.controller;

import com.southwind.entity.User;
import com.southwind.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return "user端口是：" + this.port;
    }

    @GetMapping("/findall")
    public List<User> findAll(@RequestParam("index") int index, @RequestParam("limit") int limit){
        return userRepository.findAll(index, limit);
    }

    @GetMapping("/findbyid/{id}")
    public User findById(@PathVariable("id") Long id){
        return userRepository.findById(id);
    }

    @GetMapping("/count")
    public int count(){
        return userRepository.count();
    }

    @PostMapping("/add")
    public void add(@RequestBody User user){
        userRepository.add(user);
    }

    @PutMapping("update")
    public void update(@RequestBody User user){
        userRepository.update(user);
    }

    @DeleteMapping("/deletebyid")
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}
