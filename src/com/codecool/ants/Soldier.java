package com.codecool.ants;

import com.codecool.grid.Cell;
import com.codecool.util.RandomGenerator;

public class Soldier extends Ant {

    private char facing;

    public Soldier(Cell cell) {
        super(cell);
        char[] orientations = new char[]{'N', 'S', 'E', 'W'};
        facing = orientations[RandomGenerator.generateRandIntInRange(0, 3)];
    }

    @Override
    public void move() {

        switch (facing) {
            case 'N':
                this.setPositionY(this.getPositionY() - 1);
                this.facing = 'E';
                break;
            case 'E':
                this.setPositionX(this.getPositionX() - 1);
                this.facing = 'S';
                break;
            case 'S':
                this.setPositionY(this.getPositionY() + 1);
                this.facing = 'W';
                break;
            case 'W':
                this.setPositionX(this.getPositionX() + 1);
                this.facing = 'N';
                break;
        }
        super.move();
    }

    @Override
    public String getCellType() {
        return "Soldier";
    }
}
