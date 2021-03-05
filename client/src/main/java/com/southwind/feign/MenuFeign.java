package com.southwind.feign;

import com.southwind.entity.MenuVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("menu")
public interface MenuFeign {
    @GetMapping("/menu/findall/{index}/{limit}")
    public MenuVO findall(@PathVariable("index") int index, @PathVariable("limit") int limit);
}
