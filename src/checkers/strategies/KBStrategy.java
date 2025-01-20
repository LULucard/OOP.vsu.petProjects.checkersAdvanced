package checkers.strategies;

import checkers.*;
import checkers.Point;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class KBStrategy implements PlayerStrategy {
    public static final Factory FACTORY = new Factory() {
        @Override
        public PlayerStrategy create() {
            return new KBStrategy();
        }
    };
    private final static Random rnd = new Random();
    @Override
    public void makeMove(PlayerBoard pb, MoveMaker mm) {
        List<Point> availableFigure = new ArrayList<>();

    }

}
