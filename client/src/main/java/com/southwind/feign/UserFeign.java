package com.southwind.feign;

import com.southwind.entity.User;
import com.southwind.entity.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("user")
public interface UserFeign {
    @GetMapping("/user/findall")
    public UserVO findAll(@RequestParam("index") int index, @RequestParam("limit") int limit);

    @GetMapping("/user/findbyid/{id}")
    public User findById(@PathVariable("id") Long id);

    @GetMapping("/user/count")
    public int count();

    @PostMapping("/user/add")
    public void add(User user);

    @PutMapping("/user/update")
    public void update(User user);

    @DeleteMapping("/user/deletebyid/{id}")
    public void deleteById(@PathVariable("id") Long id);
}
