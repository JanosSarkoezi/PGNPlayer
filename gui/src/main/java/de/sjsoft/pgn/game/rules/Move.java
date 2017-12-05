package de.sjsoft.pgn.game.rules;

import de.sjsoft.pgn.game.board.Board;
import de.sjsoft.pgn.game.board.Tile;
import de.sjsoft.pgn.game.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

/**
 * @author saj
 */
public class Move {
    private Board board;
    private List<Tile> legalMoves = new ArrayList<>();

    public Move(Board board) {
        this.board = board;
    }

    public List<Tile> legalMoves(Piece piece) {
        Tile startTile = piece.getTile();
        List<Direction> directions = piece.getRule().getDirections();
        for (Direction direction : directions) {
            for(Coordinate endPosition = startTile.getCoordinate().add(direction); endPosition != null; endPosition = endPosition.add(direction)) {
                Tile tile = board.getTile(endPosition);
                tile.setReachable(true);
                legalMoves.add(tile);

                if(!piece.isLongMover()) {
                    break;
                }
            }
        }

        return legalMoves;
    }
}
