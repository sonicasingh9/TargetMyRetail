package com.tgt.myRetail.repository;

import com.tgt.myRetail.entity.Pricing;
import com.tgt.myRetail.entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {

}
