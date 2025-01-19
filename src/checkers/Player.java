package checkers;

public class Player {
    private final String name;
    private final PlayerStrategy strategy;
    private final Figure figure;

    public Player(String name, PlayerStrategy strategy, Figure figure) {
        this.name = name;
        this.strategy = strategy;
        this.figure = figure;
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
}
