package com.codecool.ants;

import com.codecool.grid.Cell;
import com.codecool.interfaces.Mateable;

public class Queen extends Ant implements Mateable {

    private int countDown = 0;

    public Queen(Cell cell) {
        super(cell);
    }

    @Override
    public boolean mating() {
        if (countDown != 0) {
            --countDown;
            return false;
        }
        else {
            countDown = 100;
            return true;
        }

    }

    @Override
    public void setPositionX(int x) {
        super.setPositionX(x);
        queenX = x;
    }

    @Override
    public void setPositionY(int y) {
        super.setPositionY(y);
        queenY = y;
    }

    @Override
    public String getCellType() {
        return "Queen";
    }
}
