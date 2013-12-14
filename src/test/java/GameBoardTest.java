package test.java;

import junit.framework.TestCase;
import main.java.GameBoard;
import main.java.Player;
import main.java.Point;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: jac
 * Date: 12/13/13
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameBoardTest extends TestCase {

    @Test
    public void testMarkBoard(){
        GameBoard gb = new GameBoard();
        Point point = new Point(1,1);
        gb.markBoard(Player.X, point);
        assertTrue(gb.getMarkAtPoint(point).equals(Player.X.getMark()));
    }


    @Test
    public void testIsWinner(){
        GameBoard gb = new GameBoard();
        Point point = new Point(0,0);
        Point point2 = new Point(1,1);
        Point point3 = new Point(2,2);
        gb.markBoard(Player.X, point);
        gb.markBoard(Player.X, point2);
        gb.markBoard(Player.X, point3);
        assertTrue(gb.isWinner(Player.X));



    }
}
