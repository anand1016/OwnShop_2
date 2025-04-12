package com.anand.ownshop.user;

import com.anand.ownshop.bill.CreditBill;
import com.anand.ownshop.village.Village;
import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @RequestMapping(method = RequestMethod.POST,value = "/village/{villageId}/user")
    public void addUser(@RequestBody User u,@PathVariable int villageId){
        logger.info("adding userdetails to village {}",villageId);
        u.setVillage(new Village(villageId,""));
        //TODO add validation on village why we are adding village name empty while adding user
        logger.info("Village set for user account details");
        service.addUser(u);
        logger.info("user added name {}",u.getUserName()); //TODO: should print user id
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
