package de.sjsoft.pgn.game.board.util;

import de.sjsoft.pgn.game.rules.Coordinate;

import java.util.function.Function;

/**
 * @author saj
 */
public class CoordinateFunction implements Function<String, Coordinate> {
    String columns = "abcdefgh";

    @Override
    public Coordinate apply(String coordinate) {
        String[] coordinates = coordinate.split("");
        return new Coordinate(columns.indexOf(coordinates[0]), Integer.valueOf(coordinates[1])-1);
    }
}
