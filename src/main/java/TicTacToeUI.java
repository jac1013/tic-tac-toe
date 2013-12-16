package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: jac
 * Date: 12/14/13
 * Time: 11:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class TicTacToeUI extends JPanel {
    private static final String FONT_FAMILY = "Times New Roman";
    private static ArrayList<JButton> buttons;
    private Player currentPlayer;
    private GameBoard gameBoard;
    private JLabel infoLabel;
    private static Font buttonFont = new Font(FONT_FAMILY, Font.PLAIN, 60);


    public TicTacToeUI() {
        buttons = new ArrayList<JButton>();
        currentPlayer = Player.X;
        gameBoard = new GameBoard();
        setLayout(new GridLayout(4, 3));
        configureButtons();
        configureInfoLabel();
        configureNewGameButton();

    }

    private void configureButtons() {
        JButton button;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                button = new JButton("");
                button.setName("" + i + " " + j);
                buttons.add(button);
                addMouseClickListener(button);
                button.setFont(buttonFont);
                add(button);
            }
        }
    }

    private void addMouseClickListener(final JButton button) {
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (button.isEnabled()) {
                    markButton(button);
                    if (gameBoard.isWinner(currentPlayer)) {
                        highlightWinnerCombination();

                    } else if (isDeuce()) {
                        JOptionPane.showMessageDialog(new JFrame(), "Deuce!");
                        resetGame();

                    } else {
                        currentPlayer = currentPlayer.equals(Player.X) ? Player.O : Player.X;
                        infoLabel.setText(getInfoLabelMessage());
                    }

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }

    private void markButton(JButton button) {
        button.setText(currentPlayer.getMark());
        button.setEnabled(false);
        String[] coordinates = button.getName().split(" ");
        gameBoard.markBoard(currentPlayer, new Point(Integer.valueOf(coordinates[0]), Integer.valueOf(coordinates[1])));
    }

    private void highlightWinnerCombination() {

        for (int i = 0; i < buttons.size(); i++) {
            for (int j = 0; j < gameBoard.getWinnerCombination().length; j++) {
                if (gameBoard.getWinnerCombination()[j].equals(buttons.get(i).getName())) {
                    buttons.get(i).setBackground(Color.GREEN);
                }
            }
        }


    }

    private boolean isDeuce() {
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).isEnabled()) {
                return false;
            }
        }
        return true;
    }

    private void resetGame() {
        gameBoard = new GameBoard();
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setText("");
            buttons.get(i).setEnabled(true);
            buttons.get(i).setBackground(null);
            currentPlayer = Player.X;
        }
    }

    private String getInfoLabelMessage(){
        return "Player " + currentPlayer.getMark() + ", your turn.";
    }

    private void configureInfoLabel(){
        Font labelFont = new Font(FONT_FAMILY, Font.PLAIN, 24);
        infoLabel = new JLabel(getInfoLabelMessage());
        infoLabel.setFont(labelFont);
        infoLabel.setPreferredSize(new Dimension(200, 50));
        add(infoLabel);
    }

    private void configureNewGameButton(){

        JPanel panelNewButton = new JPanel();
        panelNewButton.setLayout(new GridBagLayout());
        JButton newGame = new JButton("New Game");
        newGame.setSize(new Dimension(100, 50));
        settleResetFuctionToButton(newGame);
        panelNewButton.add(newGame);
        add(panelNewButton);
    }

    private void settleResetFuctionToButton(JButton newGame){
        newGame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                resetGame();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Tic Tac Toe");
        f.add(new TicTacToeUI());
        f.pack();
        f.setSize(new Dimension(500, 500));
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
