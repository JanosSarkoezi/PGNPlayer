package de.sjsoft.pgn.game.board;

import de.sjsoft.pgn.game.board.util.CoordinateFunction;
import de.sjsoft.pgn.game.board.util.PieceFunction;
import de.sjsoft.pgn.game.pieces.Piece;
import de.sjsoft.pgn.game.rules.Coordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Diese Klasse representiert ein Schachbrett. Das Schachbrett wird als ein zweidimensionales Objekt aufgebaut.
 *
 * @author saj
 */
public class Board {
    //private List<Tile> tiles = new ArrayList<>();
    private Map<Coordinate, Tile> tilesCache = new HashMap<>();

    /**
     * Ein Konstruktor. Hier werden die 64 Felder des Schachbretts erstellt. Alle Felder sind leer.
     */
    public Board() {
        for (int y = 0; y < 8; ++y) {
            for (int x = 0; x < 8; ++x) {
                initEmptyTile(x, y);
            }
        }
    }

    /**
     * Diese Methode erstellt eine Figur auf dem Schachbrett. Die Figur wird im Parameter {@code piece} übergebe. Dieser
     * Parameter besteht aus 3 Zeichen.
     * <p>
     * 1. Zeichen beschreibt die Figuren im Schach:</li>
     * <table>
     * <thead>
     * <tr><th>Figur</th><th>Farbe</th><th>Symbol</th></tr>
     * </thead>
     * <tbody>
     * <tr><td>König</td><td>Weiß</td><td align="center">K</td></tr>
     * <tr><td>Dame</td><td>Weiß</td><td align="center">Q</td></tr>
     * <tr><td>Turm</td><td>Weiß</td><td align="center">R</td></tr>
     * <tr><td>Läufer</td><td>Weiß</td><td align="center">B</td></tr>
     * <tr><td>Springer</td><td>Weiß</td><td align="center">N</td></tr>
     * <tr><td>Bauer</td><td>Weiß</td><td align="center">P</td></tr>
     * <tr><td>König</td><td>Schwarz</td><td align="center">k</td></tr>
     * <tr><td>Dame</td><td>Schwarz</td><td align="center">q</td></tr>
     * <tr><td>Turm</td><td>Schwarz</td><td align="center">r</td></tr>
     * <tr><td>Läufer</td><td>Schwarz</td><td align="center">b</td></tr>
     * <tr><td>Springer</td><td>Schwarz</td><td align="center">n</td></tr>
     * <tr><td>Bauer</td><td>Schwarz</td><td align="center">p</td></tr>
     * </tbody>
     * </table>
     * <p>
     * 2. Zeichen beschreibt die Spalten des Schachbretts. Üblicher weise sind das die Buchstaben a-h.
     * <p>
     * 3. Zeichen beschreibt die Zeilen des Schachbretts. Üblicher weise sind das die Zahlen 1-8.
     *
     * @param piece Eine Figur als String representiert.
     * @return Die erstelle Figur.
     */
    public Piece createPiece(String piece) {
        String abbreviation = piece.substring(0, 1);
        String position = piece.substring(1);

        Tile tile = getTile(new CoordinateFunction().apply(position));
        tile.setPiece(new PieceFunction(tile).apply(abbreviation));

        return tile.getPiece();
    }

    /**
     * Diese Methode gibt ein Feld des Schachbretts zurück. Das Feld wird mit der Klasse {@link Coordinate} adressiert.
     * Zum Beispiel wird das Feld 'a1' mit den Koordinaten (0,0) erreicht und das Feld 'd8' mit den Koordinaten (3,7).
     *
     * @param coordinate Für die Adressierung eines Feldes des Schachbretts.
     * @return Ein Feld des Schachbretts.
     */
    public Tile getTile(Coordinate coordinate) {
        return tilesCache.get(coordinate);

    }

    private void initEmptyTile(int x, int y) {
        Color color = null;

        if ((x + y) % 2 == 0) {
            color = Color.BLACK;
        } else {
            color = Color.WHITE;
        }

        Coordinate coordinate = new Coordinate(x,y);
        tilesCache.put(coordinate, new Tile(coordinate, color, this));
    }
}
