package com.southwind.controller;

import com.southwind.entity.Menu;
import com.southwind.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuHandler {
    @Value("${server.port}")
    private String port;

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/index")
    public String index(){
        return "menu的端口是：" + port;
    }

    @GetMapping("/findall/{index}/{limit}")
    public List<Menu> findall(@PathVariable("index") int index, @PathVariable("limit") int limit){
        return menuRepository.findAll(index, limit);

    }



}
