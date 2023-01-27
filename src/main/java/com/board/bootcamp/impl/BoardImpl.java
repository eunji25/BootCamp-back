package com.board.bootcamp.impl;

import com.board.bootcamp.model.board.Board;
import com.board.bootcamp.model.board.sdo.BoardCdo;
import com.board.bootcamp.store.BoardStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardImpl {

    private final BoardStore boardStore;

    public BoardCdo newBoard(BoardCdo boardCdo) {
        List<Board> boardList = boardStore.retrieveAll();
        boardCdo.setBoardNo(String.valueOf(boardList.size() + 1));
        boardCdo.setRegisterTime(String.valueOf(new Date()));
        boardStore.create(boardCdo);
        return boardCdo;
    }

    public void modifyBoard(Board board) {
        boardStore.update(board);
    }

//    public BoardRdo findByBoardNo(String boardNo) {
//        List<Board> boardList = boardStore.retri(boardNo);
//        BoardRdo boardRdo = new BoardRdo(boardList);
//        return boardRdo;
//    }

    public Board findById(String id) {
        Board board = boardStore.retrieveById(id);
        return board;
    }

    public List<Board> retrieveAll() {
        List<Board> boardList = boardStore.retrieveAll();
        return boardList;
    }

}
