package com.anand.ownshop.user;

import com.anand.ownshop.bill.CreditBill;
import com.anand.ownshop.bill.CreditBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private CreditBillRepository creditBillRepository;

    public List<User> getAllUser(){
        List<User> list=new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }
    public List<User> getAllUserByVillageId( int villageId){
        return repository.findByVillageVillageId(villageId);
    }

    public User getUserById(int userId){
        Optional<User> v= repository.findById(userId);
        return v.orElse(null);
    }

    public void addUser( User u){
        repository.save(u);
    }

    public void deleteUser( int userId){
        repository.deleteById(userId);
    }

    public void updateUser(){
        //TODO: update statement for user
    }

    public void addBillToUser(CreditBill bill,int userId){
        repository.findById(userId).map(user -> {
            bill.setUser(user);
            creditBillRepository.save(bill);
            System.out.println("added successfully");
            return null;
        });
    }
}
