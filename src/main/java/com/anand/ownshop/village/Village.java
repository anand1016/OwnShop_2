package com.anand.ownshop.village;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Village {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer villageId;
    private String villageName;

    public Village(){

    }
    public Village(Integer villageId, String villageName) {
        this.villageId = villageId;
        this.villageName = villageName;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }
}
