package com.codecool.grid;

import com.codecool.ants.Ant;
import com.codecool.interfaces.Printable;

public class Cell implements Printable {

    private String type;
    private Ant ant;
    private Grid antHill;
    private int x, y;

    public Cell(Grid grid, int x, int y) {
        this.type = "Ground";
        this.antHill = grid;
        this.x = x;
        this.y = y;
    }

    public Grid getAntHill() {
        return antHill;
    }

    public String getType() {
        return this.type;
    }

    public void setAnt(Ant ant) {
        if (ant == null) {
            this.ant = null;
            this.type = "Ground";
        }
        else {
            this.ant = ant;
            this.type = this.ant.getCellType();
        }
    }

    public Ant getAnt() {
        return this.ant;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Cell getNeighbor(int dx, int dy) {
        return antHill.getCell(x + dx, y + dy);
    }

    @Override
    public String getCellType() {
        return this.type;
    }
}
