package de.sjsoft.pgn.game.pieces;

import de.sjsoft.pgn.game.board.Color;
import de.sjsoft.pgn.game.board.Tile;
import de.sjsoft.pgn.game.rules.Direction;
import de.sjsoft.pgn.game.rules.Rule;

/**
 * Diese Klasse representiert einen Bauern.
 *
 * @author saj
 */
public class Pawn extends Piece {
    private Rule specialRule;
    private boolean firstMove = true;

    public Pawn(Tile tile, Color color) {
        super(tile, color);

        rule = new Rule();
        specialRule = new Rule();

        if (color == Color.WHITE) {
            rule.getDirections().add(new Direction(0, 1));
            rule.getDirections().add(new Direction(0, 2));
            specialRule.getDirections().add(new Direction(1, 1));
            specialRule.getDirections().add(new Direction(-1, 1));
        } else {
            rule.getDirections().add(new Direction(0, -1));
            rule.getDirections().add(new Direction(0, -2));
            specialRule.getDirections().add(new Direction(-1, -1));
            specialRule.getDirections().add(new Direction(1, -1));
        }
    }

    @Override
    public char getAbbreviation() {
        return color == Color.BLACK ? 'p' : 'P';
    }

    @Override
    public boolean isLongMover() {
        return false;
    }

    @Override
    public boolean hasSpecialMove() {
        return true;
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }
}
