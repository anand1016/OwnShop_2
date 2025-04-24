package com.anand.ownshop.user;

import com.anand.ownshop.bill.CreditBill;
import com.anand.ownshop.village.Village;
import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    //private static final Logger logger = LogManager.getLogger(UserController.class);
    private static final Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService service;
    @RequestMapping("/users")
    public List<User> getAllUser(){
        logger.info("fetching to fetch all user");
        return service.getAllUser();
    }

    @RequestMapping("/village/{villageId}/users")
    public List<User> getAllUserByVillageId(@PathVariable int villageId){
        logger.info("fetching userdetails by Villeage for village id :{}" , villageId);
        return service.getAllUserByVillageId(villageId);
    }

    @RequestMapping("/users/{userId}")
    public User getUserById(@PathVariable int userId){
        logger.info("fetching userdetails by userId :{}" , userId);
        return service.getUserById(userId);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/users")
    public ResponseEntity<?> addUser(@RequestBody User u){
        try{
            logger.info("adding userdetails to village {}",u.getVillage().getVillageId());
            service.addUser(u);
            logger.info("user added name {}",u.getUserName()); //TODO: should print user id
            Map<String, String> response = new HashMap<>();
            response.put("message", "User saved successfully");
            logger.info("request completed succesfully");
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            logger.warn("Request to add village failed");
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/user/{userId}")
    public void deleteUser(@PathVariable int userId){
        logger.warn("deleting user with userID {}",userId);
        service.deleteUser(userId);
        logger.info("user delete {}",userId);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/user")
    public void updateUser(){
        //TODO updateing user logic build is pending
        service.updateUser();
    }

    @PostMapping("users/{userId}/bills")
    public void addBillToUser(@PathVariable int userId, @RequestBody CreditBill bill) {
        service.addBillToUser(bill,userId);
    }


}
