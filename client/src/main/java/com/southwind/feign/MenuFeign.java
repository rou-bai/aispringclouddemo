package com.southwind.feign;

import com.southwind.entity.MenuVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("menu")
public interface MenuFeign {
    @GetMapping("/menu/findall")
    public MenuVO findAll(@RequestParam("index") int index, @RequestParam("limit") int limit);

    @DeleteMapping("/menu/deletebyid/{id}")
    public void deleteById(@PathVariable("id") Long id);
}
