package com.board.bootcamp.controller;

import com.board.bootcamp.impl.UserImpl;
import com.board.bootcamp.model.user.User;
import com.board.bootcamp.model.user.sdo.UserCdo;
import com.board.bootcamp.model.user.vo.ERole;
import com.board.bootcamp.payload.query.LoginQuery;
import com.board.bootcamp.payload.query.SignupQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/auth")
public class UserController {

    private final UserImpl userImpl;

    @PostMapping("/login")
    public User authenticateUser(@Valid @RequestBody LoginQuery query) {
        log.debug("query: " + query);
        String email = query.getEmail();
        String password = query.getPassword();
        return userImpl.signIn(email, password);
    }

    @PostMapping("/signup")
    public void registerUser(@RequestBody SignupQuery query) {
        log.debug("query: " + query);

        // Create new user's account
        UserCdo userCdo = new UserCdo(
                query.getUserName(),
                query.getEmail(),
                query.getPassword());

        if (query.getRoles().equals("ADMIN")) {
            userCdo.setRoles(ERole.ADMIN);
        } else {
            userCdo.setRoles(ERole.USER);
        }

        userImpl.signUp(userCdo);
    }
}
