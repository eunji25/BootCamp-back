package com.board.bootcamp.store.mongo;

import com.board.bootcamp.model.user.User;
import com.board.bootcamp.model.user.sdo.UserCdo;
import com.board.bootcamp.store.UserStore;
import com.board.bootcamp.store.mongo.odm.UserDoc;
import com.board.bootcamp.store.mongo.repository.UserMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserMongoStore implements UserStore {

    private final UserMongoRepository userMongoRepository;

    public UserMongoStore(UserMongoRepository userMongoRepository) {
        this.userMongoRepository = userMongoRepository;
    }

    @Override
    public void create(UserCdo memberCdo) {
        UserDoc userDoc = new UserDoc(memberCdo);
        userDoc.setId(UUID.randomUUID().toString());
        userMongoRepository.insert(userDoc);
    }

    @Override
    public void createAll(List<UserCdo> memberCdos) {
        if (memberCdos == null) {
            return;
        }
        memberCdos.forEach(this::create);
    }

    @Override
    public void update(User user) {
        UserDoc memberDoc = new UserDoc(user);
        userMongoRepository.save(memberDoc);
    }

    @Override
    public void save(UserCdo userCdo) {
        UserDoc userDoc = new UserDoc(userCdo);
        userMongoRepository.save(userDoc);
    }

    @Override
    public User findByUserName(String userName) {
        UserDoc userDoc = userMongoRepository.findByUserName(userName);
        return userDoc.toDomain();
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        UserDoc userDoc = userMongoRepository.findByEmailAndPassword(email, password);
        return userDoc.toDomain();
    }

}
