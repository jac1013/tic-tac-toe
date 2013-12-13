package main.java;

/**
 * Created with IntelliJ IDEA.
 * User: jac
 * Date: 12/13/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameBoard {
    private String [][] board;

    public GameBoard() {
          board = new String[3][3];
    }

    public void markBoard(Player player, Point point) {
              board[point.getRow()][point.getColumn()] = player.getMark();
    }

    public String getMarkAtPoint(Point point){
           return board[point.getRow()][point.getColumn()];
    }
}
