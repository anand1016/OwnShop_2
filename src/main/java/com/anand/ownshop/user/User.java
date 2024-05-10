package com.anand.ownshop.user;

import com.anand.ownshop.bill.CreditBill;
import com.anand.ownshop.bill.DebitBill;
import com.anand.ownshop.village.Village;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    private String fatherName;
    private Integer number;
    @ManyToOne
    private Village village;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<CreditBill> creditBills;
    public User(){

    }

    public List<CreditBill> getCreditBills() {
        return creditBills;
    }

    public void setCreditBills(List<CreditBill> creditBills) {
        this.creditBills = creditBills;
    }

    public User(int userId, String userName, String fatherName, Integer number, Village village) {
        this.userId = userId;
        this.userName = userName;
        this.fatherName = fatherName;
        this.number = number;
        this.village = village;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

}
