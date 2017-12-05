import de.sjsoft.pgn.game.board.Board;
import de.sjsoft.pgn.game.board.Color;
import de.sjsoft.pgn.game.board.Tile;
import de.sjsoft.pgn.game.pieces.Piece;
import de.sjsoft.pgn.game.rules.Coordinate;
import de.sjsoft.pgn.game.rules.Move;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author saj
 */
public class BoardTest {
    @Test
    public void testLegalMoveKingAta1() {
        Board board = new Board();
        Piece ka1 = board.createPiece("Ka1");

        Move move = new Move(board);
        List<Tile> tiles = move.legalMoves(ka1);
        Assert.assertEquals(3, tiles.size());
    }

    @Test
    public void testLegalMoveQueenAtd1() {
        Board board = new Board();
        Piece qd1 = board.createPiece("Qd1");

        Move move = new Move(board);
        List<Tile> tiles = move.legalMoves(qd1);
        Assert.assertEquals(21, tiles.size());
    }

    @Test
    public void testLegalMoveQueenAta1() {
        Board board = new Board();
        Piece qd1 = board.createPiece("Qa1");

        Move move = new Move(board);
        List<Tile> tiles = move.legalMoves(qd1);
        Assert.assertEquals(21, tiles.size());
    }

    @Test
    public void testLegalMoveKnightAtd1() {
        Board board = new Board();
        Piece nd1 = board.createPiece("Nd1");

        Move move = new Move(board);
        List<Tile> tiles = move.legalMoves(nd1);
        Assert.assertEquals(4, tiles.size());
    }

    @Test
    public void testLegalMoveKnightAtd4() {
        Board board = new Board();
        Piece nd4 = board.createPiece("Nd4");

        Move move = new Move(board);
        List<Tile> tiles = move.legalMoves(nd4);
        Assert.assertEquals(8, tiles.size());
    }

    @Test
    public void testLegalMoveKnightAtb4() {
        Board board = new Board();
        Piece nb4 = board.createPiece("Nb4");

        Move move = new Move(board);
        List<Tile> tiles = move.legalMoves(nb4);
        Assert.assertEquals(6, tiles.size());
    }

    @Test
    public void testLegalMoveKnightAta1() {
        Board board = new Board();
        Piece na1 = board.createPiece("Na1");

        Move move = new Move(board);
        List<Tile> tiles = move.legalMoves(na1);
        Assert.assertEquals(2, tiles.size());
    }

    @Test
    public void testLegalMoveBishopAta1() {
        Board board = new Board();
        Piece ba1 = board.createPiece("Ba1");

        Move move = new Move(board);
        List<Tile> tiles = move.legalMoves(ba1);
        Assert.assertEquals(7, tiles.size());
    }


    @Test
    public void testLegalMoveKnightAth8() {
        Board board = new Board();
        Piece nh8 = board.createPiece("Nh8");

        Move move = new Move(board);
        List<Tile> tiles = move.legalMoves(nh8);
        Assert.assertEquals(2, tiles.size());
        printBoard(board);
    }

    private class X {
        private Y y;

        public X(Y y) {
            this.y = y;
        }

        public Y getY() {
            return y;
        }
    }

    private class Y {
        private X x;

        public Y(X x) {
            this.x = x;
        }

        public X getX() {
            return x;
        }
    }

    private char getTileSymbol(Tile tile) {
        char tileSymbol;
        if (tile.getColor() == Color.BLACK) {
            tileSymbol = '.';
        } else {
            tileSymbol = ' ';
        }

        if (tile.isReachable()) {
            tileSymbol = '*';
        }

        if (tile.getPiece() != null) {
            tileSymbol = tile.getPiece().getAbbreviation();
        }

        return tileSymbol;
    }

    private void printBoard(Board board) {
        for (int y = 0; y < 8; ++y) {
            for (int x = 0; x < 8; ++x) {
                System.out.print(getTileSymbol(board.getTile(new Coordinate(x, 7 - y))));
            }
            System.out.println("");
        }
    }
}
