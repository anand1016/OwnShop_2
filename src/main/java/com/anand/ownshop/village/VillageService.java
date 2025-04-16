package com.anand.ownshop.village;

import com.anand.ownshop.item.Item;
import com.anand.ownshop.item.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger= LoggerFactory.getLogger(VillageService.class);
    public List<Village> getAllVillage(){
        List<Village> list=new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public void addVillage( Village v){
       //TODO : add condition to validate if village already added or not based on Name
        logger.info("Fetching details before adding if Village name already exits");
        Optional<Village> v1=repository.findByVillageNameIgnoreCase(v.getVillageName());
        if(v1.isPresent()) {
            logger.warn("Village already exist with id {}",v1.get().getVillageId());
        }
        else{
            logger.info("no village found with name {} proceding with add command",v.getVillageName());
            repository.save(v);
            logger.info("Village saved");
        }

    }

    public void updateVillage(Integer id,Village v){
        //checking if village is available
        logger.info("Fetching details before update if Village name already exits");
        Optional<Village> v1=repository.findById(id);
        if(v1.isPresent()){
            Village village=v1.get();
            logger.info("Village found with village id {}",village.getVillageId());
            village.setVillageName(v.getVillageName());
            repository.save(village);
            logger.info("Village updated successfully with");
        }
        else{
            logger.info("Village search returned null");
            //TODO: should though exception in case village not found
        }

    }

    public void deleteVillage(int villageId){
        logger.info("fetching the details to delete with villageid {}",villageId);
        Optional<Village> v1=repository.findById(villageId);
        if(v1.isPresent()) {
            logger.info("Village found with");
            //TODO: another check before deletion is to have check if any user are linked with this village name
            repository.deleteById(villageId);
            logger.info("Village deleted successfully");
        }
        else{
            logger.info("Village search returned null in delete process");
            //TODO: should though exception in case village not found
        }

    }

    public Village getVillageById(int villageId){
        logger.info("fetching the details with villageid {}",villageId);
        Optional<Village> v=repository.findById(villageId);
        if (v.isPresent()) {
            logger.info("Village found with ID");
            return  v.get();

        } else {
            logger.info("Village not found");
            return null;
        }
    }
}
