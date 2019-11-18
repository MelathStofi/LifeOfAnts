package com.codecool.ants;

import com.codecool.grid.Cell;
import com.codecool.util.RandomGenerator;

public class Drone extends Ant {

    private boolean isMating = true;
    private int counter = 0;

    public Drone(Cell cell) {
        super(cell);
    }

    @Override
    public String getCellType() {
        return "Drone";
    }

    public String saySomething() {
        if (getDistanceFromTheQueen() <= 4){
            if (isMating) return "D'OH";
            else return "HALLELUJAH";
        }
        else return "";
    }

    @Override
    public void move() {
        if (getDistanceFromTheQueen() <= 4) {
            if (getCell().getAntHill().getQueen().mating() && counter == 0 && isMating) {
                isMating = false;
                counter = 10;
            }
            else if (counter != 0){
                --counter;
            }
            else {
                isMating = true;
                int randX = RandomGenerator.generateRandIntInRange(0, 100);
                int randY = 100 - randX;
                this.setPositionX(randX);
                this.setPositionY(randY);
            }
        }
        else {
            if (queenX > this.getPositionX())
                this.setPositionX(this.getPositionX() + 1);
            else if (queenX < this.getPositionX())
                this.setPositionX(this.getPositionX() - 1);

            if (queenY > this.getPositionY())
                this.setPositionY(this.getPositionY() + 1);
            else if (queenY < this.getPositionY())
                this.setPositionY(this.getPositionY() - 1);
        }
        super.move();
    }

}
