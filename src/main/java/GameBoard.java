package main.java;

/**
 * Created with IntelliJ IDEA.
 * User: jac
 * Date: 12/13/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameBoard {
    private String[][] board;
    private String[] winnerCombination;


    public GameBoard() {
        winnerCombination = new String[3];
        initializeGameBoard();
    }

    private void initializeGameBoard() {
        board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "";
            }
        }
    }

    public String[] getWinnerCombination() {
        return winnerCombination;
    }

    public void markBoard(Player player, Point point) {
        board[point.getRow()][point.getColumn()] = player.getMark();
    }

    public String getMarkAtPoint(Point point) {
        return board[point.getRow()][point.getColumn()];
    }

    public boolean isWinner(Player player) {
        return checkDiagonals(player) || checkColumns(player) || checkRows(player);
    }

    private boolean checkDiagonals(Player player) {
        boolean isWinner = false;
        if ((board[0][0].equals(player.getMark()) &&
                board[1][1].equals(player.getMark()) &&
                board[2][2].equals(player.getMark()))) {
            winnerCombination[0] = "0 0";
            winnerCombination[1] = "1 1";
            winnerCombination[2] = "2 2";
            isWinner = true;

        } else if ((board[0][2].equals(player.getMark()) &&
                board[1][1].equals(player.getMark()) &&
                board[2][0].equals(player.getMark()))) {
            winnerCombination[0] = "0 2";
            winnerCombination[1] = "1 1";
            winnerCombination[2] = "2 0";
            isWinner = true;
        }
        return isWinner;
    }

    private boolean checkColumns(Player player) {
        boolean isWinner = false;
        if ((board[0][0].equals(player.getMark()) &&
                board[0][1].equals(player.getMark()) &&
                board[0][2].equals(player.getMark()))) {
            winnerCombination[0] = "0 0";
            winnerCombination[1] = "0 1";
            winnerCombination[2] = "0 2";
            isWinner = true;
        } else if ((board[1][0].equals(player.getMark()) &&
                board[1][1].equals(player.getMark()) &&
                board[1][2].equals(player.getMark()))) {
            winnerCombination[0] = "1 0";
            winnerCombination[1] = "1 1";
            winnerCombination[2] = "1 2";
            isWinner = true;
        } else if ((board[2][0].equals(player.getMark()) &&
                board[2][1].equals(player.getMark()) &&
                board[2][2].equals(player.getMark()))) {
            winnerCombination[0] = "2 0";
            winnerCombination[1] = "2 1";
            winnerCombination[2] = "2 2";
            isWinner = true;
        }
        return isWinner;
    }

    private boolean checkRows(Player player) {
        boolean isWinner = false;
        if ((board[0][0].equals(player.getMark()) &&
                board[1][0].equals(player.getMark()) &&
                board[2][0].equals(player.getMark()))) {
            winnerCombination[0] = "0 0";
            winnerCombination[1] = "1 0";
            winnerCombination[2] = "2 0";
            isWinner = true;
        } else if ((board[0][1].equals(player.getMark()) &&
                board[1][1].equals(player.getMark()) &&
                board[2][1].equals(player.getMark()))) {
            winnerCombination[0] = "0 1";
            winnerCombination[1] = "1 1";
            winnerCombination[2] = "2 1";
            isWinner = true;
        } else if ((board[0][2].equals(player.getMark()) &&
                board[1][2].equals(player.getMark()) &&
                board[2][2].equals(player.getMark()))) {
            winnerCombination[0] = "0 2";
            winnerCombination[1] = "1 2";
            winnerCombination[2] = "2 2";
            isWinner = true;
        }
        return isWinner;
    }


}
