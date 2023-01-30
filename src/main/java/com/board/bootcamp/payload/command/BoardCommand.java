package com.board.bootcamp.payload.command;

import com.board.bootcamp.model.board.sdo.BoardCdo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardCommand {

    private BoardCdo boardCdo;

}
