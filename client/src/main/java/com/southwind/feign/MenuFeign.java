package com.southwind.feign;

import com.southwind.entity.Menu;
import com.southwind.entity.MenuVO;
import com.southwind.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("menu")
public interface MenuFeign {
    @GetMapping("/menu/findall")
    public MenuVO findAll(@RequestParam("index") int index, @RequestParam("limit") int limit);

    @DeleteMapping("/menu/deletebyid/{id}")
    public void deleteById(@PathVariable("id") Long id);

    @GetMapping("/menu/findtypes")
    public List<Type> findTypes();

    @PostMapping("/menu/add")
    public void add(Menu menu);

    @PostMapping("/menu/update")
    public void update(Menu menu);

    @GetMapping("/menu/findbyid/{id}")
    public Menu findById(@PathVariable("id") long id);
}
