package checkers.unitTests;

import checkers.Board;

public class boardTest {
    public static void main(String[] args) {
        Board br = new Board(8,8);
        System.out.println(br.get(6,1));
    }
}
