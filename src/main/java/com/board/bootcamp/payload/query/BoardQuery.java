package com.board.bootcamp.payload.query;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardQuery {
    String id;

    public BoardQuery(String id) {
        this.id = id;
    }
}
