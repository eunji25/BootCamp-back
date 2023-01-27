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

//    @Autowired
//    public void setBoardImpl(BoardImpl boardImpl) {
//        this.boardImpl = boardImpl;
//    }

    @PostMapping(value = "/new-board")
    public BoardCdo newBoard (@RequestBody BoardCommand command) {
//        BoardCdo boardCdo = BoardCdo.sample();
        BoardCdo boardCdo = command.getBoardCdo();
        return boardImpl.newBoard(boardCdo);
    }

//    @PostMapping("/find-board")
//    public BoardRdo findByBoardNo (@RequestBody BoardQuery query) {
//        String boardNo = query.getBoardNo();
//        BoardRdo response = boardImpl.findByBoardNo(boardNo);
//        return response;
//    }

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

}
