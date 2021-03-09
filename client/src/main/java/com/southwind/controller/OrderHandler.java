package com.southwind.controller;

import com.southwind.entity.Menu;
import com.southwind.entity.Order;
import com.southwind.entity.OrderVO;
import com.southwind.entity.User;
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

}
