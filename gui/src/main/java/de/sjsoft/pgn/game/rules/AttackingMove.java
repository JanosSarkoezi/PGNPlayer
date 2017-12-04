package de.sjsoft.pgn.game.rules;

import de.sjsoft.pgn.game.board.Board;
import de.sjsoft.pgn.game.board.Tile;
import de.sjsoft.pgn.game.pieces.Piece;

/**
 * @author saj
 */
public class AttackingMove extends Move {
    public AttackingMove(Board board, Piece piece) {
        super(board, piece);
    }
}
