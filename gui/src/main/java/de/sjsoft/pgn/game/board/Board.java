package de.sjsoft.pgn.game.board;

import de.sjsoft.pgn.game.board.util.CoordinateFunction;
import de.sjsoft.pgn.game.board.util.PieceFunction;
import de.sjsoft.pgn.game.pieces.Piece;
import de.sjsoft.pgn.game.rules.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author saj
 */
public class Board {
    private List<Tile> tiles = new ArrayList<>();

    public Board() {
        for (int y = 0; y < 8; ++y) {
            for (int x = 0; x < 8; ++x) {
                initEmptyTile(x, y);
            }
        }
    }

    public Piece createPiece(String piece) {
        String abbreviation = piece.substring(0, 1);
        String position = piece.substring(1);

        Tile tile = getTile(new CoordinateFunction().apply(position));
        tile.setPiece(new PieceFunction(tile).apply(abbreviation));

        return tile.getPiece();
    }

    public Tile getTile(Coordinate coordinate) {
        Optional<Tile> foundTile = tiles.stream()
                .filter(tile -> tile.getCoordinate().equals(coordinate))
                .findFirst();

        if (!foundTile.isPresent()) {
            throw new NoSuchElementException();
        }

        return foundTile.get();

    }

    private void initEmptyTile(int x, int y) {
        Color color = null;

        if ((x + y) % 2 == 0) {
            color = Color.BLACK;
        } else {
            color = Color.WHITE;
        }

        tiles.add(new Tile(new Coordinate(x, y), color));
    }
}
