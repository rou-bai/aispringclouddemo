package com.southwind.controller;

import com.southwind.entity.*;
import com.southwind.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderHandler {
    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/add/{mid}")
    public String add(@PathVariable("mid") long mid,
                      HttpSession session){
        User user = (User)session.getAttribute("user");
        Order order = new Order();
        order.setUser(user);
        Menu menu = new Menu();
        menu.setId(mid);
        order.setMenu(menu);
        orderFeign.add(order);
        return "order";
    }

    @GetMapping("/findbyuid")
    @ResponseBody
    public OrderVO findAllByUid(@RequestParam("page") int page,
                                @RequestParam("limit") int limit,
                                HttpSession session){
        int index = (page - 1) * limit;
        User user = (User)session.getAttribute("user");
        return orderFeign.findByUid(index, limit, user.getId());
    }

    @GetMapping("/findbystate")
    @ResponseBody
    public OrderVO findByState(@RequestParam("page") int page,
                               @RequestParam("limit") int limit){
        int index = (page -1) * limit;
        return orderFeign.findByState(index, limit, 0);
    }

    @GetMapping("/updatestatebyid/{id}/{state}")
    public String updateStateById(@PathVariable("id") Long id,
                                  @PathVariable("state") int state,
                                  HttpSession session){
        Admin admin = (Admin)session.getAttribute("admin");
        orderFeign.updateStateById(id, state, admin.getId());
        return "order_handler";
    }

}
