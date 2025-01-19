package checkers;

public interface PlayerStrategy {
    interface Factory {
        PlayerStrategy create();
    }

    void makeMove(PlayerBoard pb, MoveMaker mm);
}
