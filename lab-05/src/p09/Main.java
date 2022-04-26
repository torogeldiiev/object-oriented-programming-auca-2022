package p09;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame {
    JPanel mainPanel;


    Model game = new Model();

    Main() {
        mainPanel = new CanvasPanel();
        mainPanel.setBackground(Color.BLACK);
        add(mainPanel, BorderLayout.CENTER);

        mainPanel.setFocusable(true);
        mainPanel.requestFocus();
        mainPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed (KeyEvent e){
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    game.moveUp();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    game.moveDown();
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    game.moveLeft();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    game.moveRight();
                }
                repaint();
            }
        });

    }

    public static void main(String[] args) {
        Main frame = new Main();
        frame.setTitle("Chessboard");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    class CanvasPanel extends JPanel{
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);


            int cellWidth = (int) (Math.round(getWidth() / 8.0));
            int cellHeight = (int) (Math.round(getHeight() / 8.0));
            for (int r = 0; r < 8; r++) {
                for (int c = 0; c < 8; c++) {
                    if (r % 2 == 0 && c % 2 == 0 || r % 2 != 0 && c % 2 != 0) {
                        g.setColor(Color.WHITE);
                    }else{
                        g.fillRect(c * cellWidth,r * cellHeight,cellWidth,cellHeight);
                    }
                }
            }
            g.setColor(Color.RED);
            g.fillOval(game.getRobotCol() * cellWidth, game.getRobotRow() * cellHeight, cellWidth,cellHeight);
        }
    }
}