package com.ketul.demo.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ketul.demo.module.User;

@Repository
public interface UserRepo extends MongoRepository<User, Long> {

}
