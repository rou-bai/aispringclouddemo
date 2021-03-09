package com.southwind.controller;

import com.southwind.entity.Order;
import com.southwind.entity.OrderVO;
import com.southwind.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderHandler {
    @Autowired
    private OrderRepository orderRepository;
    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return "order端口是：" + this.port;
    }

    @PostMapping("/add")
    public void add(@RequestBody Order order){
        order.setDate(new Date());
        orderRepository.add(order);
    }

    @GetMapping("/findbyuid/{index}/{limit}/{uid}")
    public OrderVO findByUid(@PathVariable("index") int index,
                             @PathVariable("limit") int limit,
                             @PathVariable("uid") Long uid){
        return new OrderVO(0, "", orderRepository.countByUid(uid), orderRepository.findByUid(index, limit, uid));
    }

    @GetMapping("/countbyuid/{uid}")
    public int CountByUid(@PathVariable("uid") Long uid){
        return orderRepository.countByUid(uid);
    }

    @GetMapping("/findbystate/{index}/{limit}/{state}")
    public OrderVO findByState(@PathVariable("index") int index,
                               @PathVariable("limit") int limit,
                               @PathVariable("state") int state){
        return new OrderVO(0, "", orderRepository.countByState(state), orderRepository.findByState(index, limit, state));
    }

    @GetMapping("/countbystate/{state}")
    public int countByState(@PathVariable("state") int state){
        return orderRepository.countByState(state);
    }

    @PutMapping("/updatestatebyid/{id}/{state}/{aid}")
    public void updateStateById(@PathVariable("id") Long id,
                                @PathVariable("state") int state,
                                @PathVariable("aid") Long aid){
        orderRepository.updateStateById(id, state, aid);
    }
}
