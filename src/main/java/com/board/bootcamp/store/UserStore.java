package com.board.bootcamp.store;

import com.board.bootcamp.model.user.User;
import com.board.bootcamp.model.user.sdo.UserCdo;

import java.util.List;

public interface UserStore {
    void create(UserCdo userCdo);
    void createAll(List<UserCdo> userCdos);

    void update(User user);
    void save(UserCdo userCdo);

    User findByUserName(String userName);
    User findByEmailAndPassword(String email, String password);
//    Boolean existsByUserName(String userName);
//    Boolean existsByEmail(String email);
}
