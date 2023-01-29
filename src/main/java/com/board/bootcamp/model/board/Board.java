package com.board.bootcamp.model.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Board {

    private String id;

    private String registerTime;
    private String modificationTime;

    private String boardNo;
    private String title;
    private String content;
    private String image;

    private String email;
    private String userName;

}
