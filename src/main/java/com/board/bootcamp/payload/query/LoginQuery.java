package com.board.bootcamp.payload.query;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class LoginQuery {
    private String email;
    private String password;

}
