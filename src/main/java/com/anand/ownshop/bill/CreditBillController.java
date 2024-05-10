package com.anand.ownshop.bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreditBillController {
    @Autowired
    private CreditBillService service;

    @RequestMapping("/creditbills")
    public List<CreditBill> getAllBill(){
        return service.getAllBill();
    }
}
