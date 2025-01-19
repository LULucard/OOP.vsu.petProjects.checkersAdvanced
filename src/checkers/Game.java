package checkers;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Boardable<Figure> board;
    private List<Player> players = new ArrayList<>();
    private int currentPlayerIndex = 0;
    private int stepsCount = 0;

    private Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    private void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        stepsCount++;
    }

    public Game(Boardable<Figure> board, Player a, Player b) {
        this.board = board;
        players.add(a);
        players.add(b);
    }

    private static class PBoard implements PlayerBoard {

        private final Boardable<Figure> board;
        private final Figure figure;

        public PBoard(Boardable<Figure> board, Figure figure) {
            this.board = board;
            this.figure = figure;
        }

        @Override
        public int getWidth() {
            return board.getWidth();
        }

        @Override
        public int getHeight() {
            return board.getHeight();
        }

        @Override
        public Cell getCell(Point p) {
            Figure f = board.get(p.getX(), p.getY());
            if (f == null)
                return Cell.EMPTY;
            if (f == figure)
                return Cell.ALLY;
            return Cell.ENEMY;
        }
    }

    private class MakeMoveImpl implements MoveMaker {

        @Override
        public void makeMove(Point p) {
            Player pl = getCurrentPlayer();
            if (p != null) {
                board.set(p.getX(), p.getY(), pl.getFigure());
                nextPlayer();
            }
            if (isGameOver())
                return;
            pl = getCurrentPlayer();
            PBoard pb = new PBoard(board, pl.getFigure());
            getCurrentPlayer().getStrategy().makeMove(pb, new MakeMoveImpl());
        }
    }

    public void start() {
        Player pl = getCurrentPlayer();
        PBoard pb = new PBoard(board, pl.getFigure());
        getCurrentPlayer().getStrategy().makeMove(pb, new MakeMoveImpl());
    }

    public boolean isGameOver() {
        return false;
    } //Допишу

}
