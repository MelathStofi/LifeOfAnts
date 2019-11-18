package com.codecool.ants;

import com.codecool.grid.Cell;
import com.codecool.interfaces.Printable;

public abstract class Ant implements Printable {

    static int queenX, queenY;
    private Cell cell;
    private int positionX, positionY;
    private int distanceFromTheQueen;

    protected Ant(Cell cell) {
        this.cell = cell;
        this.positionX = cell.getX();
        this.positionY = cell.getY();
    }

    public void move() {
        int mapWidth = cell.getAntHill().getWidth() -1;
        int mapHeight = cell.getAntHill().getWidth() -1;
        if (positionX > mapWidth) --positionX;
        if (positionX < 1) ++positionX;
        if (positionY > mapHeight) --positionY;
        if (positionY < 1) ++positionY;
    }

    public int getPositionX() {
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public void setPositionX(int x) {
        this.positionX = x;
    }

    public void setPositionY(int y) {
        this.positionY = y;
    }

    public int getDistanceFromTheQueen() {
        return (positionX - queenX) + (positionY - queenY);
    }

    public Cell getCell() {
        return this.cell;
    }
}
