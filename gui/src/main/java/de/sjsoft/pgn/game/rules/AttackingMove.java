package de.sjsoft.pgn.game.rules;

import de.sjsoft.pgn.game.board.Board;
import de.sjsoft.pgn.game.board.Tile;

/**
 * @author saj
 */
public class AttackingMove extends Move {
    public AttackingMove(Board board, Tile startPosition) {
        super(board, startPosition);
    }
}
