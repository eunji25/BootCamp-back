package com.board.bootcamp.store;

import com.board.bootcamp.model.board.Board;
import com.board.bootcamp.model.board.sdo.BoardCdo;

import java.util.List;

public interface BoardStore {
    void create(BoardCdo boardCdo);
    void createAll(List<BoardCdo> boardCdos);
    void update(Board board);

    Board retrieveById(String id);
    List<Board> retrieveAll();
//    List<Board> retrieveByBoardNo(String boardNo);
}
