package com.board.bootcamp.payload.query;

import com.board.bootcamp.model.user.vo.ERole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupQuery {
    private String id;

    private String userName;
    private String email;
    private ERole roles;
    private String password;
}
