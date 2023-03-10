package com.board.bootcamp.controller;

import com.board.bootcamp.model.board.Board;
import com.board.bootcamp.model.board.sdo.BoardCdo;
import com.board.bootcamp.payload.command.BoardCommand;
import com.board.bootcamp.payload.query.BoardQuery;
import com.board.bootcamp.impl.BoardImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardImpl boardImpl;

    @PostMapping(value = "/new-board")
    public BoardCdo newBoard (@RequestBody BoardCommand command) {
        BoardCdo boardCdo = command.getBoardCdo();
        return boardImpl.newBoard(boardCdo);
    }

    @PostMapping("/find-detail-board")
    public Board findDetailBoard (@RequestBody BoardQuery query) {
        Board response = boardImpl.findById(query.getId());
        return response;
    }

    @PostMapping("/find-board-list")
    public List<Board> findBoardList () {
        List<Board> response = boardImpl.retrieveAll();
        return response;
    }

    @PostMapping("/delete-board")
    public void deleteBoard (@RequestBody BoardQuery query) {
        boardImpl.deleteBoard(query.getId());
    }

    @PostMapping("/modify-board")
    public void modifyBoard (@RequestBody BoardCommand command) {
        boardImpl.modifyBoard(command.getBoardCdo());
    }

}
