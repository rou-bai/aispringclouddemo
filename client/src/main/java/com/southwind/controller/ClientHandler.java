package com.southwind.controller.controller;

import com.southwind.entity.Menu;
import com.southwind.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientHandler {
    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findall/{index}/{limit}")
    public List<Menu> findall(@PathVariable("index") int index, @PathVariable("limit") int limit){
        return menuFeign.findall(index, limit);
    }


}
