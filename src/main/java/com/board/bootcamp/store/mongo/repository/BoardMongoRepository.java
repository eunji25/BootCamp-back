package com.board.bootcamp.store.mongo.repository;

import com.board.bootcamp.store.mongo.odm.BoardDoc;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface BoardMongoRepository extends MongoRepository<BoardDoc, String> {

//    List<BoardDoc> findByWriterIdLikeAndTitle(String writerId, String title);
    Optional<BoardDoc> findById(String id);
}
