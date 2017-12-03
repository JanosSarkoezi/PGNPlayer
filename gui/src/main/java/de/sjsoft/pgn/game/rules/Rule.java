package de.sjsoft.pgn.game.rules;

import java.util.ArrayList;
import java.util.List;

/**
 * @author saj
 */
public class Rule {
    private final List<Direction> directions = new ArrayList<>();

    public List<Direction> getDirections() {
        return directions;
    }
}
