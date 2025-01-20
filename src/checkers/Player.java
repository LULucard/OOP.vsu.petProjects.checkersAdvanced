package checkers;

public class Player {
    private final String name;
    private final PlayerStrategy strategy;
    private final Figure figure;
    private final Figure qf;

    public Player(String name, PlayerStrategy strategy, Figure figure, Figure qf) {
        this.name = name;
        this.strategy = strategy;
        this.figure = figure;
        this.qf = qf;
    }

    public String getName() {
        return name;
    }

    public PlayerStrategy getStrategy() {
        return strategy;
    }

    public Figure getFigure() {
        return figure;
    }

    public Figure getQueenFigure() {
        return qf;
    }
}
