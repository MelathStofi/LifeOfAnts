package com.codecool.ants;

import com.codecool.grid.Cell;
import com.codecool.util.RandomGenerator;

public class Worker extends Ant {

    public Worker(Cell cell) {
        super(cell);
    }

    @Override
    public void move() {
        this.setPositionX(this.getPositionX() + RandomGenerator.generateRandIntInRange(-1, 1));
        this.setPositionY(this.getPositionY() + RandomGenerator.generateRandIntInRange(-1, 1));
        super.move();
    }

    @Override
    public String getCellType() {
        return "Worker";
    }

}
