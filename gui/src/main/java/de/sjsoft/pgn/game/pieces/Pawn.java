package de.sjsoft.pgn.game.pieces;

import de.sjsoft.pgn.game.board.Color;
import de.sjsoft.pgn.game.board.Tile;

/**
 * @author saj
 */
public class Pawn extends Piece {
    public Pawn(Tile tile, Color color) {
        super(tile, color);
    }

    @Override
    public char getAbbreviation() {
        return color == Color.BLACK ? 'p' : 'P';
    }

    @Override
    public boolean isLongMover() {
        return false;
    }
}
