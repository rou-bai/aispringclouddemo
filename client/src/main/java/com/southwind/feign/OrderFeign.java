package com.southwind.feign;

import com.southwind.entity.Order;
import com.southwind.entity.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("order")
public interface OrderFeign {
    @PostMapping("/order/add")
    public void add(@RequestBody Order order);

    @GetMapping("/order/findbyuid/{index}/{limit}/{uid}")
    public OrderVO findByUid(@PathVariable("index") int index,
                           @PathVariable("limit") int limit,
                           @PathVariable("uid") Long uid);
}
