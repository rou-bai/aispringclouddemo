package com.southwind.controller;

import com.southwind.entity.Menu;
import com.southwind.entity.MenuVO;
import com.southwind.entity.Type;
import com.southwind.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
//          区别：PathVariable用于 /xxx/参数
//               RequestParam用于 /xxx?aa=参数&&bb=参数

//@RestController 这个返回的是rest的json数据
@Controller  //这个返回视图，可以和页面交互
@RequestMapping("/menu")
public class MenuHandler {
    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findall")
    @ResponseBody  //这个注解用来告诉返回的是数据不是视图
    //feign的客户端和服务端请求返回格式和参数类似要对应！！不然就出现坑爹的404
    public MenuVO findAll(@RequestParam(value="page", required=false) int page,
                          @RequestParam("limit") int limit){
        int index = 0;
        if (page > 0){
            index = (page - 1) * limit;}
        return menuFeign.findAll(index, limit);
    }

    @GetMapping("/index")
    public String index(){
        return "menu_manage";
    }

    @GetMapping("/deletebyid/{id}")
    public String deleteById(@PathVariable("id") Long id){
        menuFeign.deleteById(id);
        return "redirect:/menu/index";
    }

    @GetMapping("/findtypes")
    public ModelAndView findTypes(){
        //将数据传递给前端的方法：ModelAndView
        ModelAndView model = new ModelAndView();
        model.setViewName("menu_add");
        model.addObject("types", menuFeign.findTypes());
        List<Type> types = menuFeign.findTypes();
        return model;
    }

    @PostMapping("/add")
    public String add(Menu menu){
        menuFeign.add(menu);
        return "menu_manage";
    }

    @PostMapping("/update")
    public String update(Menu menu){
        menuFeign.update(menu);
        return "redirect:/menu/index";
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable("id") Long id, Model model){
//        另一种传递值到页面到方法, model
        model.addAttribute("menu", menuFeign.findById(id));
        model.addAttribute("types", menuFeign.findTypes());
        return "menu_update";
    }
}
