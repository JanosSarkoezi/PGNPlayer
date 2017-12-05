package de.sjsoft.pgn.game.board;

import de.sjsoft.pgn.game.pieces.Piece;
import de.sjsoft.pgn.game.rules.Coordinate;
import de.sjsoft.pgn.game.rules.Direction;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author saj
 */
public class Tile {
    private Color color;
    private Piece piece;
    private Board board;
    private Coordinate coordinate;
    private boolean reachable = false;

    public Tile(Coordinate coordinate, Color color, Board board) {
        this.board = board;
        this.color = color;
        this.coordinate = coordinate;
    }

    public Color getColor() {
        return color;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public boolean isReachable() {
        return reachable;
    }

    public void setReachable(boolean reachable) {
        this.reachable = reachable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return new EqualsBuilder()
                .append(coordinate, tile.coordinate)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(coordinate)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .toString();
    }
}
