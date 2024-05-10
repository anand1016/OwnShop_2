package com.anand.ownshop.bill;

import com.anand.ownshop.item.Item;
import com.anand.ownshop.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class CreditBill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int billId;
    private int amount;
    @OneToMany
    private List<Item> items;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User user;
    public CreditBill(){

    }

    public CreditBill(int billId, int amount, List<Item> items, User user) {
        this.billId = billId;
        this.amount = amount;
        this.items = items;
        this.user = user;
    }

    public int getBillId() {
        return billId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
