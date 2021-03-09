package com.southwind.controller;

import com.southwind.entity.Admin;
import com.southwind.entity.User;
import com.southwind.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("type") String type,
                        HttpSession session){
        Object object = accountFeign.login(username, password, type);
        //Object值是一个hashmap,不能直接和User/Admin类型转化
        LinkedHashMap<String, Object> hashMap = (LinkedHashMap)object;
        if(object == null){
            return "login";
        }
        switch (type){
            case ("user"):
                User user = new User();
                String idStr = hashMap.get("id") + "";
                Long id = Long.parseLong(idStr);
                String name = (String)hashMap.get("username");
                user.setId(id);
                user.setUsername(name);
                session.setAttribute("user", user);

                return "redirect:/menu/index";
            case("admin"):
                Admin admin = new Admin();
                String admiIdStr = hashMap.get("id") + "";
                Long adminId = Long.parseLong(admiIdStr);
                String adminName = (String)hashMap.get("username");
                admin.setId(adminId);
                admin.setUsername(adminName);
                session.setAttribute("admin", admin);
                return "redirect:/user/index";
        }

        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        System.out.println(1111111);
        // 销毁session
        session.invalidate();
        return "redirect:/login.html";
    }
}
