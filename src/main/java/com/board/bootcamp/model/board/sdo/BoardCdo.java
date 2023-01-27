package com.board.bootcamp.model.board.sdo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardCdo {

    private String id;

    private String registerTime;
    private String modificationTime;

    private String boardNo;
    private String title;
    private String content;

    private String email;
    private String userName;

    public String genId() {
        return UUID.randomUUID().toString();
    }

}
