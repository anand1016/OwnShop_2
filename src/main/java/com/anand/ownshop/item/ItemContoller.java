package com.anand.ownshop.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemContoller {
    @Autowired
    private ItemService service;

    @RequestMapping("/items")
    public List<Item> getAllItem(){
        return service.getAllItem();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/items")
    public void addItem(@RequestBody  Item i){
        service.addItem(i);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/items")
    public void updateItem(@RequestBody Item i){
        //TODO: update Item logic yet to build in case of Key Auto creation
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/items/{itemId}")
    public void deleteItem(@PathVariable int itemId){
        service.deleteItem(itemId);
    }

    @RequestMapping("/items/{itemId}")
    public Item getItemById(@PathVariable int itemId){
        return service.getItemById(itemId);
    }
}
