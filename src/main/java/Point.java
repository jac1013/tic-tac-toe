package main.java;

/**
 * Created with IntelliJ IDEA.
 * User: jac
 * Date: 12/13/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Point {
    private int row, column;

    public Point(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
