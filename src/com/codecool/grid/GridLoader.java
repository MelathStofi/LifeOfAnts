package com.codecool.grid;

import com.codecool.ants.Drone;
import com.codecool.ants.Queen;
import com.codecool.ants.Soldier;
import com.codecool.ants.Worker;
import com.codecool.util.RandomGenerator;

public class GridLoader {
    public static Grid loadGrid(int width, int height) {

        Grid grid = new Grid(width, height);


        grid.addAntToGrid(new Queen(grid.getCell(0, 0)));
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (RandomGenerator.chanceEvaluator(5)) {
                    Cell cell = grid.getCell(x, y);
                    switch (RandomGenerator.generateRandIntInRange(1, 3)) {
                        case 1:
                            grid.addAntToGrid(new Worker(cell));
                            break;
                        case 2:
                            if (x > 0 && x < width-2 && y > 0 && y < height-2) {
                                grid.addAntToGrid(new Soldier(cell));
                            }
                            break;
                        case 3:
                            grid.addAntToGrid(new Drone(cell));
                            break;
                    }
                }

            }
        }

        return grid;
    }
}
