package com.board.bootcamp.store.mongo;

import com.board.bootcamp.model.board.Board;
import com.board.bootcamp.model.board.sdo.BoardCdo;
import com.board.bootcamp.store.mongo.odm.BoardDoc;
import com.board.bootcamp.store.BoardStore;
import com.board.bootcamp.store.mongo.repository.BoardMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class BoardMongoStore implements BoardStore {

    private final BoardMongoRepository boardMongoRepository;

    public BoardMongoStore(BoardMongoRepository boardMongoRepository) {
        this.boardMongoRepository = boardMongoRepository;
    }

    @Override
    public void create(BoardCdo boardCdo) {
        BoardDoc boardDoc = new BoardDoc(boardCdo);
        boardDoc.setId(UUID.randomUUID().toString());
        boardMongoRepository.insert(boardDoc);
    }

    @Override
    public void createAll(List<BoardCdo> boardCdos) {
        if (boardCdos == null) {
            return;
        }
        boardCdos.forEach(this::create);
    }

   @Override
   public void update(BoardCdo boardCdo) {
        BoardDoc boardDoc = new BoardDoc(boardCdo);
        boardMongoRepository.save(boardDoc);
   }

    @Override
    public List<Board> retrieveAll() {
        return BoardDoc.toDomains(boardMongoRepository.findAll());
    }

    @Override
    public Board retrieveById(String id) {
        return boardMongoRepository.findById(id).map(BoardDoc::toDomain).orElse(null);
    }

    @Override
    public void delete(String id) {
        boardMongoRepository.deleteById(id);
    }

}
