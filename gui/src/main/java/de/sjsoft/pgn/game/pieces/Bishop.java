package de.sjsoft.pgn.game.pieces;

import de.sjsoft.pgn.game.board.Color;
import de.sjsoft.pgn.game.board.Tile;
import de.sjsoft.pgn.game.rules.Direction;
import de.sjsoft.pgn.game.rules.Rule;

/**
 * @author saj
 */
public class Bishop extends Piece {
    public Bishop(Tile tile, Color color) {
        super(tile, color);

        rule = new Rule();
        rule.getDirections().add(new Direction(1, 1));
        rule.getDirections().add(new Direction(-1, 1));
        rule.getDirections().add(new Direction(-1, -1));
        rule.getDirections().add(new Direction(1, -1));
    }

    @Override
    public char getAbbreviation() {
        return color == Color.BLACK ? 'b' : 'B';
    }

    @Override
    public boolean isLongMover() {
        return true;
    }

    @Override
    public boolean hasSpecialMove() {
        return false;
    }
}
