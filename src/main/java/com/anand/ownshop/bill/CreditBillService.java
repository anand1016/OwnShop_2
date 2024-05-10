package com.anand.ownshop.bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditBillService {

    @Autowired
    private CreditBillRepository repository;
    public List<CreditBill> getAllBill(){
        List<CreditBill> list=new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }
}
