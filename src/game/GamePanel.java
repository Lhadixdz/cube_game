package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class GamePanel extends JPanel implements KeyListener {

    private Maze maze = new Maze();

    private int cubeX = 40; // موقع المربع
    private int cubeY = 40;
    private final int cubeSize = 20; // حجم المربع
    private final int speed = 5; // سرعة الحركة

    public GamePanel() {
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // رسم المتاهة
        maze.draw(g);

        // رسم المربع الأحمر
        g.setColor(Color.RED);
        g.fillRect(cubeX, cubeY, cubeSize, cubeSize);
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int nextX = cubeX;
        int nextY = cubeY;

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> nextY -= speed;
            case KeyEvent.VK_DOWN -> nextY += speed;
            case KeyEvent.VK_LEFT -> nextX -= speed;
            case KeyEvent.VK_RIGHT -> nextX += speed;
        }

        if (!maze.collides(nextX, nextY, cubeSize)) {
            cubeX = nextX;
            cubeY = nextY;
        }

        repaint();
    }



    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}

