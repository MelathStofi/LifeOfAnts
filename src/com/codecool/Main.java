package com.codecool;

import com.codecool.ants.Drone;
import com.codecool.grid.Cell;
import com.codecool.grid.Grid;
import com.codecool.grid.GridLoader;
import com.codecool.util.RandomGenerator;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class Main extends JPanel implements KeyListener, ActionListener {

    private Image background = ImageIO
            .read(new File("/src/resources/ground2.jpg"))
            .getScaledInstance(1300, 800, Image.SCALE_DEFAULT);

    private Image queen = ImageIO
            .read(new File("/src/resources/queen.png"))
            .getScaledInstance(18, 18, Image.SCALE_DEFAULT);

    private Image drone = ImageIO
            .read(new File("/src/resources/drone.png"))
            .getScaledInstance(18, 18, Image.SCALE_DEFAULT);

    private Image soldier = ImageIO
            .read(new File("/src/resources/soldier.png"))
            .getScaledInstance(18, 18, Image.SCALE_DEFAULT);

    private Image worker = ImageIO
            .read(new File("/src/resources/worker.png"))
            .getScaledInstance(18, 18, Image.SCALE_DEFAULT);


    private Timer timer = new Timer(250, this);
    private Grid colony = GridLoader.loadGrid(101, 101);

    Main() throws IOException {
        timer.start();
        this.setPreferredSize(new Dimension(1000, 800));
        //addKeyListener(this);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new Main());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.BLACK);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        int start = 50 + (RandomGenerator.generateRandIntInRange(-3, 3));
        int size = 7;

        graphics.clearRect(0, 0, getWidth(), getHeight());

        graphics.drawImage(background, 0, 0, this);

        for (int x = 0; x < colony.getWidth(); x++) {
            for (int y = 0; y < colony.getHeight(); y++) {
                Cell cell = colony.getCell(x, y);

                switch (cell.getType()) {
                    case "Queen":
                        graphics.drawImage(queen, start + size * x - 20,  start + size * y - 20, this);
                        break;
                    case "Worker":
                        graphics.drawImage(worker, start + size * x,  start + size * y, this);
                        break;
                    case "Soldier":
                        graphics.drawImage(soldier, start + size * x,  start + size * y, this);
                        break;
                    case "Drone":
                        String droneTalk = ((Drone) cell.getAnt()).saySomething();
                        if (!droneTalk.equals("")) {
                            graphics.drawString(droneTalk, start + size * x,  start + size * y - 8);
                        }
                        graphics.drawImage(drone, start + size * x,  start + size * y, this);
                        break;
                    default:
                        graphics.drawImage(null, start + size * x,  start + size * y, this);
                        break;
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        colony.moveAnts();
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            colony.moveAnts();
            repaint();
        }
    }
}
