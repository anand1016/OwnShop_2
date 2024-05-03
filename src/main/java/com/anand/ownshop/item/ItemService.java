package com.anand.ownshop.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;
    public List<Item> getAllItem(){
        List<Item> list=new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public void addItem( Item i){
        repository.save(i);
    }

    public void updateItem( Item i){
    }

    public void deleteItem(int itemId){
        repository.deleteById(itemId);
    }

    public Item getItemById(int itemId){
        Optional<Item> item= repository.findById(itemId);
        if (item.isPresent()) {
            return  item.get();

        } else {
            return null;
        }
    }
}
