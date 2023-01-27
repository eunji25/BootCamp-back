package com.board.bootcamp.model.user.sdo;

import com.board.bootcamp.model.user.User;
import com.board.bootcamp.model.user.vo.ERole;
import com.board.bootcamp.model.user.vo.Role;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCdo {

    private String id;

    private String userName;
    private String email;
    private ERole roles;
    private String password;

    public String genId() {
        return UUID.randomUUID().toString();
    }

    public UserCdo(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

}
