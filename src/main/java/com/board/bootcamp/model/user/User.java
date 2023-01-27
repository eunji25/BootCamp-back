package com.board.bootcamp.model.user;

import com.board.bootcamp.model.user.vo.ERole;
import com.board.bootcamp.model.user.vo.Role;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;

    private String userName;
    private String email;
    private ERole roles;
    private String password;

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

}
