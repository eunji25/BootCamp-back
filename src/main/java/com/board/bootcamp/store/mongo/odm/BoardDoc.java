package com.board.bootcamp.store.mongo.odm;

import com.board.bootcamp.model.board.Board;
import com.board.bootcamp.model.board.sdo.BoardCdo;
import com.board.bootcamp.model.user.vo.ERole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "Board")
public class BoardDoc {

    @Id
    private String id;

    private String registerTime;
    private String modificationTime;

    private String boardNo;
    private String title;
    private String content;

    private String email;
    private String userName;
    private ERole roles;

    public BoardDoc (Board board) {
        BeanUtils.copyProperties(board, this);
    }

    public BoardDoc (BoardCdo boardCdo) {
        BeanUtils.copyProperties(boardCdo, this);
    }

    public Board toDomain() {
        Board board = new Board();
        BeanUtils.copyProperties(this, board);
        return board;
    }

    public static List<Board> toDomains (List<BoardDoc> boardDocs) {
        return boardDocs.stream().map(BoardDoc::toDomain).collect(Collectors.toList());
    }
}

