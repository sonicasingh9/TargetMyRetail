package com.tgt.myRetail.repository;

import com.tgt.myRetail.entity.Role;
import com.tgt.myRetail.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByUsername(String username);
}
