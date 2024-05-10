package com.anand.ownshop.user;

import com.anand.ownshop.bill.CreditBill;
import com.anand.ownshop.village.Village;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;
    @RequestMapping("/users")
    public List<User> getAllUser(){
        return service.getAllUser();
    }

    @RequestMapping("/village/{villageId}/users")
    public List<User> getAllUserByVillageId(@PathVariable int villageId){
        return service.getAllUserByVillageId(villageId);

    }

    @RequestMapping("/users/{userId}")
    public User getUserById(@PathVariable int userId){
        return service.getUserById(userId);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/village/{villageId}/user")
    public void addUser(@RequestBody User u,@PathVariable int villageId){
        u.setVillage(new Village(villageId,""));
        service.addUser(u);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/user/{userId}")
    public void deleteUser(@PathVariable int userId){
        service.deleteUser(userId);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/user")
    public void updateUser(){
        service.updateUser();
    }

    @PostMapping("users/{userId}/bills")
    public void addBillToUser(@PathVariable int userId, @RequestBody CreditBill bill) {
        service.addBillToUser(bill,userId);
    }


}
