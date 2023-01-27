package com.board.bootcamp.model.board.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardRef{

    private String boardNo;
    private String title;
    private String content;
}
