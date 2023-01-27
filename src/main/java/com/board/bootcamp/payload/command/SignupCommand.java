package com.board.bootcamp.payload.command;

import com.board.bootcamp.model.user.vo.ERole;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SignupCommand {
    private String token;
    private String type = "Barer";

    private String id;
    private String userName;
    private String email;
    private ERole roles;

    public SignupCommand(String token, String id, String userName, String email, ERole roles) {
        this.token = token;
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.roles = roles;
    }
}
