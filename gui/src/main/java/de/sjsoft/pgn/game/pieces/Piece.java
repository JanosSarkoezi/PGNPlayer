package de.sjsoft.pgn.game.pieces;

import de.sjsoft.pgn.game.board.Color;
import de.sjsoft.pgn.game.board.Tile;
import de.sjsoft.pgn.game.rules.Rule;

/**
 * @author saj
 */
public abstract class Piece {
    protected Rule rule;
    protected Tile tile;
    protected final Color color;

    public Piece(Tile tile,Color color) {
        this.tile = tile;
        this.color = color;
    }

    public abstract char getAbbreviation();
    public abstract boolean isLongMover();
    public abstract boolean hasSpecialMove();

    public Rule getRule() {
        return rule;
    }

    public Tile getTile() {
        return tile;
    }
}
