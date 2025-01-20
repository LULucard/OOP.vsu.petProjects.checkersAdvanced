package checkers;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Boardable<Figure> board;
    private List<Player> players = new ArrayList<>();
    private int currentPlayerIndex = 0;

    private Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    private void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public Game(Boardable<Figure> board, Player a, Player b) {
        this.board = board;
        players.add(a);
        players.add(b);
    }

    public boolean isMoveAllowed(Point s, Point f) {
        return false; //Чекает, доступен ли этот шаг игроку
    }

    public List<Point> allowedMoves(Point p){
        return new ArrayList<>();//Чекает доступные шаги для шашки
    }


    private static class PBoard implements PlayerBoard {

        private final Boardable<Figure> board;
        private final Figure figure;
        private final Figure qf;

        public PBoard(Boardable<Figure> board, Figure figure, Figure qf) {
            this.board = board;
            this.figure = figure;
            this.qf = qf;
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
            if ((f == figure) || (f == qf))
                return Cell.ALLY;
            return Cell.ENEMY;
        }

    }

    private class MakeMoveImpl implements MoveMaker {

        @Override
        public void makeMove(Point s, Point f) {
            Player pl = getCurrentPlayer();
            if (isMoveAllowed(s, f)) {
                board.set(f.getX(), f.getY(), board.get(s.getX(), s.getY()));
                board.set(s.getX(), s.getY(), null);
                nextPlayer();
            }
            if (isGameOver())
                return;
            pl = getCurrentPlayer();
            PBoard pb = new PBoard(board, pl.getFigure(), pl.getQueenFigure());
            getCurrentPlayer().getStrategy().makeMove(pb, new MakeMoveImpl());
        }


    }


    public void start() {
        Player pl = getCurrentPlayer();
        PBoard pb = new PBoard(board, pl.getFigure(), pl.getQueenFigure());
        getCurrentPlayer().getStrategy().makeMove(pb, new MakeMoveImpl());
    }

    public boolean isGameOver() {
        return false;
    } //Допишу

}
