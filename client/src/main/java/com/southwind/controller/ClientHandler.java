package com.southwind.controller;

import com.southwind.entity.Menu;
import com.southwind.entity.MenuVO;
import com.southwind.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController 这个返回的是rest的json数据
@Controller  //这个返回视图，可以和页面交互
@RequestMapping("/client")
public class ClientHandler {
    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findall")
    @ResponseBody  //这个注解用来告诉返回的是数据不是视图
    public MenuVO findall(@RequestParam("page") int page,
                          @RequestParam("limit") int limit){
        int index = (page - 1) * limit;
        return menuFeign.findall(index, limit);
    }

    @GetMapping("/index")
    public String index(){
        return "/index";
    }


}
