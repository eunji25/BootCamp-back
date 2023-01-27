package com.board.bootcamp.impl;

import com.board.bootcamp.model.user.User;
import com.board.bootcamp.model.user.sdo.UserCdo;
import com.board.bootcamp.store.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserImpl {

    private final UserStore userStore;

    public UserCdo newMember(UserCdo memberCdo) {
        userStore.create(memberCdo);
        return memberCdo;
    }

    public User signIn(String email, String password) {
        User user = userStore.findByEmailAndPassword(email, password);
        return user;
    }

    public void signUp(UserCdo userCdo) {
        userStore.create(userCdo);
    }

}
