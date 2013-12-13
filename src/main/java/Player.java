package main.java;

/**
 * Created with IntelliJ IDEA.
 * User: jac
 * Date: 12/13/13
 * Time: 1:34 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Player {
    X("X"), O("O");

    private Player(String mark) {
        this.mark = mark;
    }

    private String mark;

    public String getMark() {
        return mark;
    }
}
