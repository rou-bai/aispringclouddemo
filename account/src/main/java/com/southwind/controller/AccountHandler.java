package com.southwind.controller;

import com.southwind.repository.AdminRepository;
import com.southwind.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/account")
public class AccountHandler {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/login")
    public Object login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("type") String type){
        Object object = null; //返回类未知，用object对象去赋值
        switch (type){
            case "user":
                object = userRepository.login(username, password);
                break;
            case "admin":
                object = adminRepository.login(username, password);
                break;
        }
        return object;
    }
}
