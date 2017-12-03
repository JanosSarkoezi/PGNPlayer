package de.sjsoft.pgn.game.board.util;

import de.sjsoft.pgn.game.board.Color;
import de.sjsoft.pgn.game.board.Tile;
import de.sjsoft.pgn.game.pieces.Bishop;
import de.sjsoft.pgn.game.pieces.King;
import de.sjsoft.pgn.game.pieces.Knight;
import de.sjsoft.pgn.game.pieces.Pawn;
import de.sjsoft.pgn.game.pieces.Piece;
import de.sjsoft.pgn.game.pieces.Queen;
import de.sjsoft.pgn.game.pieces.Rock;

import java.util.function.Function;

/**
 * @author saj
 */
public class PieceFunction implements Function<String, Piece> {
    private Piece piece = null;
    private Tile tile;

    public PieceFunction(Tile tile) {
        this.tile = tile;
    }

    @Override
    public Piece apply(String abbreviation) {
        piece = createPawn(abbreviation);
        piece = createRock(abbreviation);
        piece = createKnight(abbreviation);
        piece = createBishop(abbreviation);
        piece = createQueen(abbreviation);
        piece = createKing(abbreviation);

        return piece;
    }

    private Piece createPawn(String abbreviation) {
        if(abbreviation.equals("p")) {
            piece = new Pawn(tile, Color.BLACK);
        } else if(abbreviation.equals("P")) {
            piece = new Pawn(tile, Color.WHITE);
        }

        return piece;
    }

    private Piece createRock(String abbreviation) {
        if(abbreviation.equals("r")) {
            piece = new Rock(tile, Color.BLACK);
        } else if(abbreviation.equals("R")) {
            piece = new Rock(tile, Color.WHITE);
        }

        return piece;
    }

    private Piece createKnight(String abbreviation) {
        if(abbreviation.equals("n")) {
            piece = new Knight(tile, Color.BLACK);
        } else if(abbreviation.equals("N")) {
            piece = new Knight(tile, Color.WHITE);
        }

        return piece;
    }

    private Piece createBishop(String abbreviation) {
        if(abbreviation.equals("b")) {
            piece = new Bishop(tile, Color.BLACK);
        } else if(abbreviation.equals("B")) {
            piece = new Bishop(tile, Color.WHITE);
        }

        return piece;
    }

    private Piece createQueen(String abbreviation) {
        if(abbreviation.equals("q")) {
            piece = new Queen(tile, Color.BLACK);
        } else if(abbreviation.equals("Q")) {
            piece = new Queen(tile, Color.WHITE);
        }

        return piece;
    }

    private Piece createKing(String abbreviation) {
        if(abbreviation.equals("k")) {
            piece = new King(tile, Color.BLACK);
        } else if(abbreviation.equals("K")) {
            piece = new King(tile, Color.WHITE);
        }

        return piece;
    }
}
