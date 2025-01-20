package checkers;

public class Board implements Boardable<Figure> {
    private Figure[][] b;

    public Board(int width, int height) {
        b = new Figure[height][width];
        int stepCount = 1;
        for (int i = 0; i < (height / 2); i++) {
            for (int j = 0; j < width; j++) {
                if ((stepCount % 2) == 0) {
                    this.set(j, i, Figure.x);
                }
                stepCount++;
            }
            stepCount -= 1;
        }
        stepCount = 1;
        for (int i = (height / 2) + 1; i < (height - 1); i++) {
            for (int j = 0; j < width; j++) {
                if ((stepCount % 2) == 1) {
                    this.set(j, i, Figure.o);
                }
                stepCount++;
            }
            stepCount -= 1;
        }
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
