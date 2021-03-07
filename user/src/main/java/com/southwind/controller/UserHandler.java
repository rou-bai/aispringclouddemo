package com.southwind.controller;

import com.southwind.entity.User;
import com.southwind.entity.UserVO;
import com.southwind.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public UserVO findAll(@RequestParam("index") int index, @RequestParam("limit") int limit){
        return new UserVO(0, "", userRepository.count(), userRepository.findAll(index, limit));
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
        user.setRegisterdate(new Date());
        userRepository.add(user);
    }

    @PutMapping("update")
    public void update(@RequestBody User user){
        userRepository.update(user);
    }

    @DeleteMapping("/deletebyid/{id}")
    public void deleteById(@PathVariable("id") Long id){
        userRepository.deleteById(id);
    }
}
