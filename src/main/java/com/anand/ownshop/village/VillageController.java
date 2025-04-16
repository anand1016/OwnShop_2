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
    public void addVillage(@RequestBody Village v){
        logger.info("adding new village {}",v.getVillageName());
        service.addVillage(v);
        logger.info("village succesfully added {}",v.getVillageName());
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/village/{id}")
    public void updateVillage(@PathVariable Integer id, @RequestBody Village v){
        service.updateVillage(id,v);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/village/{villageId}")
    public void deleteVillage(@PathVariable int villageId){
        logger.warn("deleting village {}",villageId);
        service.deleteVillage(villageId);
    }

    @RequestMapping("/village/{villageId}")
    public Village getVillageById(@PathVariable int villageId){
        logger.info("fetching village details by id {}",villageId);
        return service.getVillageById(villageId);
    }
}
