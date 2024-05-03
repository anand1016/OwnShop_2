package com.anand.ownshop.village;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VillageController {
    @Autowired
    private VillageService service;

    @RequestMapping("/village")
    public List<Village> getAllItem(){
        return service.getAllVillage();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/village")
    public void addItem(@RequestBody Village v){
        service.addVillage(v);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/village")
    public void updateItem(@RequestBody Village i){
        //TODO: update Item logic yet to build in case of Key Auto creation
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/village/{villageId}")
    public void deleteItem(@PathVariable int villageId){
        service.deleteVillage(villageId);
    }

    @RequestMapping("/village/{villageId}")
    public Village getItemById(@PathVariable int villageId){
        return service.getVillageById(villageId);
    }
}
