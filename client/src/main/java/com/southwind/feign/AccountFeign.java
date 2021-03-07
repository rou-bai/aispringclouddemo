package com.southwind.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("account")
public interface AccountFeign {
    @GetMapping("/account/login")
    public Object login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("type") String type);
    }

