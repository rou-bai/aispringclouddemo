package com.southwind.feign;

import com.southwind.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value="/user")
public interface UserFeign {
    @GetMapping("/user/findall")
    public List<User> findAll(@RequestParam("index") int index, @RequestParam("limit") int limit);

    @GetMapping("/user/findbyid/{id}")
    public User findById(@PathVariable("id") Long id);

    @GetMapping("/user/count")
    public int count();

    @PostMapping("/user/add")
    public void add(@RequestBody User user);

    @PutMapping("/user/update")
    public void update(@RequestBody User user);

    @DeleteMapping("/user/deletebyid")
    public void deleteById(Long id);
}
