package checkers.unitTests;

import checkers.Board;
import checkers.Figure;

import static java.util.Objects.isNull;
import static javax.management.Query.not;

public class boardTest {
    public static void main(String[] args) {
        Board br = new Board(8,8);
        int stepCount = 1;
        for (int i = 0; i <= 7; i++){
            for (int j = 0; j<= 7; j++){
                if (!(isNull(br.get(i,j)))) {
                    System.out.print(br.get(i, j));
                } else if (stepCount % 2 == 1){
                    System.out.print("-");
                } else {
                    System.out.print(" ");
                }
                stepCount++;
            }
            System.out.println();
            stepCount--;
        }
    }
}
