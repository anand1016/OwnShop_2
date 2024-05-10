package com.anand.ownshop.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {
    List<User> findByVillageVillageId(int villageId);
}
