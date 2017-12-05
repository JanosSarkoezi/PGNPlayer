package de.sjsoft.pgn.game.pieces;

import de.sjsoft.pgn.game.board.Color;
import de.sjsoft.pgn.game.board.Tile;
import de.sjsoft.pgn.game.rules.Direction;
import de.sjsoft.pgn.game.rules.Rule;

/**
 * @author saj
 */
public class King extends Piece {
    private Rule specialRule;
    private boolean firstMove;
    public King(Tile tile, Color color) {
        super(tile, color);

        rule = new Rule();
        rule.getDirections().add(new Direction(1, 0));
        rule.getDirections().add(new Direction(1, 1));
        rule.getDirections().add(new Direction(0, 1));
        rule.getDirections().add(new Direction(-1, 1));
        rule.getDirections().add(new Direction(-1, 0));
        rule.getDirections().add(new Direction(-1, -1));
        rule.getDirections().add(new Direction(0, -1));
        rule.getDirections().add(new Direction(1, -1));

        specialRule = new Rule();
        specialRule.getDirections().add(new Direction(2,0));
        specialRule.getDirections().add(new Direction(-2,0));
    }

    @Override
    public char getAbbreviation() {
        return color == Color.BLACK ? 'k' : 'K';
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
