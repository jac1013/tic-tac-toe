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

    public boolean isWinner(Player player){
        return checkDiagonals(player) || checkColumns(player) || checkRows(player);
    }

    private boolean checkDiagonals(Player player) {
        return (board[0][0].equals(player.getMark()) &&
                board[1][1].equals(player.getMark()) &&
                board[2][2].equals(player.getMark())) ||
               (board[0][2].equals(player.getMark()) &&
                board[1][1].equals(player.getMark()) &&
                board[2][0].equals(player.getMark()));
    }

    private boolean checkColumns(Player player) {
        return (board[0][0].equals(player.getMark()) &&
                board[0][1].equals(player.getMark()) &&
                board[0][2].equals(player.getMark())) ||
               (board[1][0].equals(player.getMark()) &&
                board[1][1].equals(player.getMark()) &&
                board[1][2].equals(player.getMark())) ||
               (board[2][0].equals(player.getMark()) &&
                board[2][1].equals(player.getMark()) &&
                board[2][2].equals(player.getMark()));
    }

    private boolean checkRows(Player player){
        return (board[0][0].equals(player.getMark()) &&
                board[1][0].equals(player.getMark()) &&
                board[2][0].equals(player.getMark())) ||
               (board[0][1].equals(player.getMark()) &&
                board[1][1].equals(player.getMark()) &&
                board[2][1].equals(player.getMark())) ||
               (board[0][2].equals(player.getMark()) &&
                board[1][2].equals(player.getMark()) &&
                board[2][2].equals(player.getMark()));
    }
}
