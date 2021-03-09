package com.southwind.feign;

import com.southwind.entity.Order;
import com.southwind.entity.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("order")
public interface OrderFeign {
    @PostMapping("/order/add")
    public void add(@RequestBody Order order);

    @GetMapping("/order/findbyuid/{index}/{limit}/{uid}")
    public OrderVO findByUid(@PathVariable("index") int index,
                             @PathVariable("limit") int limit,
                             @PathVariable("uid") Long uid);

    @GetMapping("/order/findbystate/{index}/{limit}/{state}")
    public OrderVO findByState(@PathVariable("index") int index,
                               @PathVariable("limit") int limit,
                               @PathVariable("state") int state);

    @PutMapping("/order/updatestatebyid/{id}/{state}/{aid}")
    public void updateStateById(@PathVariable("id") Long id,
                                @PathVariable("state") int state,
                                @PathVariable("aid") Long aid);
}
