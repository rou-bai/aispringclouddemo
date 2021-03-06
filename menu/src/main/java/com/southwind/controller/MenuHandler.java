package com.southwind.controller;

import com.southwind.entity.Menu;
import com.southwind.entity.MenuVO;
import com.southwind.entity.Type;
import com.southwind.repository.MenuRepository;
import com.southwind.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuHandler {
    @Value("${server.port}")
    private String port;

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private TypeRepository typeRespository;

    @GetMapping("/index")
    public String index(){
        return "menu的端口是：" + port;
    }

    @GetMapping("/findall")
    public MenuVO findall(@RequestParam("index") int index, @RequestParam("limit") int limit){
        return new MenuVO(0, "", menuRepository.count(), menuRepository.findAll(index, limit));
    }

    @DeleteMapping("/deletebyid/{id}")
    public void deleteById(@PathVariable("id") long id){
        menuRepository.deleteById(id);
    }

    @GetMapping("/findtypes")
    public List<Type> findTypes(){
        return typeRespository.findAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Menu menu){
        menuRepository.add(menu);
    }

    @GetMapping("/findbyid/{id}")
    public Menu findById(@PathVariable("id") Long id){
        return menuRepository.findById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Menu menu){
        //通过feign传递过来的是个json数据，但实际上需要但是个menu对象，必须通过requestbody注明
        menuRepository.update(menu);
    }
}
