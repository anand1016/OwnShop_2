package com.anand.ownshop.village;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VillageController {
    private static final Logger logger= LoggerFactory.getLogger(VillageController.class);
    @Autowired
    private VillageService service;

    @RequestMapping("/village")
    public List<Village> getAllVillage(){
        logger.info("fetch all details called");
        return service.getAllVillage();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/village")
    public ResponseEntity<?> addVillage(@RequestBody Village v){
        logger.info("new village addition called");
        try{
            service.addVillage(v);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Village saved successfully");
            logger.info("request completed succesfully");
            return ResponseEntity.ok(response);
        }
        catch (IllegalArgumentException e){
            logger.warn("Request to add village failed");
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }

    @RequestMapping(method = RequestMethod.PUT,value = "/village/{id}")
    public void updateVillage(@PathVariable Integer id, @RequestBody Village v){
        service.updateVillage(id,v);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/village/{villageId}")
    public ResponseEntity<?> deleteVillage(@PathVariable int villageId){
        try{
            logger.warn("deleting village {}",villageId);
            service.deleteVillage(villageId);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Village deleted successfully");
            logger.info("delete request completed succesfully");
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @RequestMapping("/village/{villageId}")
    public Village getVillageById(@PathVariable int villageId){
        logger.info("fetching village details by id {}",villageId);
        return service.getVillageById(villageId);
    }
}
