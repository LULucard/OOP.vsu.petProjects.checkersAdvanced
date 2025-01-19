package checkers;

public class Board implements Boardable<Figure> {
    private Figure[][] b;

    public Board(int width, int height) {
        b = new Figure[height][width];
    }

    @Override
    public int getWidth() {
        return b[0].length;
    }

    @Override
    public int getHeight() {
        return b.length;
    }

    @Override
    public Figure get(int row, int col) {
        return b[row][col];
    }

    @Override
    public void set(int row, int col, Figure value) {
        b[row][col] = value;
    }

}
