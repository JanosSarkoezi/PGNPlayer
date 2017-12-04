import de.sjsoft.pgn.game.board.Board;
import de.sjsoft.pgn.game.board.Color;
import de.sjsoft.pgn.game.board.Tile;
import de.sjsoft.pgn.game.pieces.Pawn;
import de.sjsoft.pgn.game.pieces.Piece;
import de.sjsoft.pgn.game.pieces.Queen;
import de.sjsoft.pgn.game.rules.Coordinate;
import de.sjsoft.pgn.game.rules.Move;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * @author saj
 */
public class BoardTest {
    @Test
    @Ignore
    public void testPrintBoard() {
        Board board = new Board();
        board.createPiece("Pa2");
        board.createPiece("Pb2");
        board.createPiece("Pc2");
        board.createPiece("Pd2");
        board.createPiece("Pe2");
        board.createPiece("Pf2");
        board.createPiece("Pg2");
        board.createPiece("Ph2");

        board.createPiece("Ra1");
        board.createPiece("Nb1");
        board.createPiece("Bc1");
        board.createPiece("Qd1");
        board.createPiece("Ke1");
        board.createPiece("Bf1");
        board.createPiece("Ng1");
        board.createPiece("Rh1");

        board.createPiece("pa7");
        board.createPiece("pb7");
        board.createPiece("pc7");
        board.createPiece("pd7");
        board.createPiece("pe7");
        board.createPiece("pf7");
        board.createPiece("pg7");
        board.createPiece("ph7");

        board.createPiece("ra8");
        board.createPiece("nb8");
        board.createPiece("bc8");
        board.createPiece("qd8");
        board.createPiece("ke8");
        board.createPiece("bf8");
        board.createPiece("ng8");
        board.createPiece("rh8");

        printBoard(board);
    }

    @Test
    public void testMoveQueend1() {
        Board board = new Board();
        Piece qd1 = board.createPiece("Qd1");

        Move move = new Move(board, qd1);
        List<Tile> tiles = move.calculateLegalMoves();
        printBoard(board);
        Assert.assertEquals(21, tiles.size());
    }

    @Test
    public void testMoveKnightd1() {
        Board board = new Board();
        Piece nd1 = board.createPiece("Nd1");

        Move move = new Move(board, nd1);
        List<Tile> tiles = move.calculateLegalMoves();
        printBoard(board);
        Assert.assertEquals(4, tiles.size());
    }

    @Test
    public void testMoveKnightd4() {
        Board board = new Board();
        Piece nd4 = board.createPiece("Nd4");

        Move move = new Move(board, nd4);
        List<Tile> tiles = move.calculateLegalMoves();
        printBoard(board);
        Assert.assertEquals(8, tiles.size());
    }

    @Test
    public void testMoveKnightb4() {
        Board board = new Board();
        Piece nb4 = board.createPiece("Nb4");

        Move move = new Move(board, nb4);
        List<Tile> tiles = move.calculateLegalMoves();
        printBoard(board);
        Assert.assertEquals(6, tiles.size());
    }

    @Test
    public void testMoveASFD() {
        Board board = new Board();
        Piece nb4 = board.createPiece("Nb4");
        Piece qd1 = board.createPiece("Qd1");

        Move moveB4 = new Move(board, nb4);
        Move moveQ1 = new Move(board, qd1);
        List<Tile> tilesB4 = moveB4.calculateLegalMoves();
        List<Tile> tilesQ1 = moveQ1.calculateLegalMoves();
        printBoard(board);
        Assert.assertEquals(6, tilesB4.size());
        Assert.assertEquals(21, tilesQ1.size());
    }

    private char getTileSymbol(Tile tile) {
        char tileSymbol;
        if (tile.getColor() == Color.BLACK) {
            tileSymbol = '.';
        } else {
            tileSymbol = ' ';
        }

        if(tile.isReachable()) {
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
