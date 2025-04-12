package com.anand.ownshop.village;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VillageController {
    private static final Logger logger= LoggerFactory.getLogger(VillageController.class);
    @Autowired
    private VillageService service;

    @RequestMapping("/village")
    public List<Village> getAllItem(){
        logger.info("fetching aa village list");
        return service.getAllVillage();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/village")
    public void addItem(@RequestBody Village v){
        logger.info("adding new village {}",v.getVillageName());
        service.addVillage(v);
        logger.info("village succesfully added {}",v.getVillageName());
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/village")
    public void updateItem(@RequestBody Village i){
        //TODO: update Item logic yet to build in case of Key Auto creation
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/village/{villageId}")
    public void deleteItem(@PathVariable int villageId){
        logger.warn("deleting village {}",villageId);
        service.deleteVillage(villageId);
        logger.info("Village deleted"); //TODO: should print name which village got deleted
    }

    @RequestMapping("/village/{villageId}")
    public Village getItemById(@PathVariable int villageId){
        logger.info("fetching village details by id {}",villageId);
        return service.getVillageById(villageId);
    }
}
