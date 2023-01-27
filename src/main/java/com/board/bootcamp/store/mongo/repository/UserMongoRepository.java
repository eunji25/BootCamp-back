package com.board.bootcamp.store.mongo.repository;

import com.board.bootcamp.store.mongo.odm.UserDoc;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<UserDoc, String> {
    UserDoc findByUserName(String userName);
    UserDoc findByEmailAndPassword(String email, String password);
    Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);
}
