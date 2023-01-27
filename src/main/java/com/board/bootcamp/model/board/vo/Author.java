package com.board.bootcamp.model.board.vo;

import com.board.bootcamp.model.user.vo.ERole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    private String id;
    private String name;
    private ERole roles;
}
