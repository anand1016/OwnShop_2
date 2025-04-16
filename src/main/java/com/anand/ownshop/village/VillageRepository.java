package com.anand.ownshop.village;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VillageRepository extends CrudRepository<Village,Integer> {
    Optional<Village> findByVillageNameIgnoreCase(String villageName);
}
