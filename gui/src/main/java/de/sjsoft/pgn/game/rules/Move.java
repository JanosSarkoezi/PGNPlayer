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
    private Tile startPosition;
    private List<Tile> legalMoves = new ArrayList<>();

    public Move(Board board, Tile startPosition) {
        this.board = board;
        this.startPosition = startPosition;
    }

    public List<Tile> calculateLegalMoves() {
        Piece piece = startPosition.getPiece();

        if(piece == null) {
            return legalMoves;
        }

        List<Direction> directions = piece.getRule().getDirections();
        for (Direction direction : directions) {
            for(Coordinate endPosition = startPosition.getCoordinate().add(direction); endPosition != null; endPosition = endPosition.add(direction)) {
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
