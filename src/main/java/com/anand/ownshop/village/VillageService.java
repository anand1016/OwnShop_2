package com.anand.ownshop.village;

import com.anand.ownshop.item.Item;
import com.anand.ownshop.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VillageService {
    @Autowired
    private VillageRepository repository;

    public List<Village> getAllVillage(){
        List<Village> list=new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public void addVillage( Village v){
        repository.save(v);
    }

    public void updateItem(Item i){
        //TODO: update Item logic yet to build in case of Key Auto creation
    }

    public void deleteVillage(int villageId){
        repository.deleteById(villageId);
    }

    public Village getVillageById(int villageId){
        Optional<Village> v=repository.findById(villageId);
        if (v.isPresent()) {
            return  v.get();

        } else {
            return null;
        }
    }
}
