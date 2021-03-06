package com.southwind.controller;

import com.southwind.entity.Menu;
import com.southwind.entity.MenuVO;
import com.southwind.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findall")
    public MenuVO findall(@RequestParam("index") int index, @RequestParam("limit") int limit){
        return new MenuVO(0, "", menuRepository.count(), menuRepository.findAll(index, limit));
    }

    @DeleteMapping("/deletebyid/{id}")
    public void deleteById(@PathVariable("id") long id){
        menuRepository.deleteById(id);
    }



}
