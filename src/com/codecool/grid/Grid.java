package com.codecool.grid;

import com.codecool.ants.Ant;
import com.codecool.ants.Drone;
import com.codecool.ants.Queen;
import com.codecool.interfaces.Mateable;

import java.util.LinkedList;
import java.util.List;

public class Grid {

    private int width, height;
    private Cell[][] cells;
    private Mateable queen;
    private List<Ant> ants;

    public Grid(int width, int height) {
        this.ants = new LinkedList<>();
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y);
            }
        }
    }

    public void moveAnts() {
        for (Ant ant: ants) {
            cells[ant.getPositionX()][ant.getPositionY()].setAnt(null);
            ant.move();
            cells[ant.getPositionX()][ant.getPositionY()].setAnt(ant);
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public Mateable getQueen() {
        return queen;
    }

    public void addAntToGrid(Ant ant) {
        int x = ant.getPositionX();
        int y = ant.getPositionY();
        cells[x][y].setAnt(ant);
        this.ants.add(ant);
        if (ant.getCellType().equals("Queen"))
            this.queen = (Mateable) ant;
    }

    public List<Ant> getAnts() {
        return this.ants;
    }

}
