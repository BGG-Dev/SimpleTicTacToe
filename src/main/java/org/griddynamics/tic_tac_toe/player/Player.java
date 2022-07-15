package org.griddynamics.tic_tac_toe.player;

import org.griddynamics.tic_tac_toe.Cell;
import org.griddynamics.tic_tac_toe.Grid;

import java.util.*;

/*
 * Abstract player class
 * All players are inherited from this class
 */
public abstract class Player {

    // Char to represent on cell/grid
    private final char sign;

    // Occupied cells
    private final List<Cell> occupied;

    // X coords set
    private final Set<Integer> xCoordSet;

    // Y coords set
    private final Set<Integer> yCoordSet;

    // Game grid
    private final Grid grid;

    /*
     * Default constructor
     */
    Player(Grid grid, char sign) {
        // Initialize by provided data
        this.grid = grid;
        this.sign = sign;

        // Initialize by default
        this.occupied = new LinkedList<>();
        this.xCoordSet = new LinkedHashSet<>(); // will be iterated many times
        this.yCoordSet = new LinkedHashSet<>(); // will be iterated many times
    }

    /*
     * Sign getter
     */
    public char getSign() {
        return sign;
    }

    /*
     * Grid getter
     */
    public Grid getGrid() {
        return this.grid;
    }

    /*
     * Make move by this player
     * Cell is selected by SelectCell method
     */
    public void makeMove() {
        // Selecting cell to make move with
        Cell selected = this.selectFreeCell();

        // Occupying
        selected.occupyByPlayer(this);

        // Adding
        this.addCellToOccupied(selected);
    }

    /*
     * Make move by this player
     * Cell is selected from player's grid
     by given coords
     */
    public void makeMove(int x, int y) {
        Cell selected = this.grid.getCell(x, y);
        if (selected.occupyByPlayer(this)) {
            this.addCellToOccupied(selected);
        }
    }

    abstract Cell selectFreeCell();

    /*
     * Checks if player has won
     */
    public boolean isWinner() {
        // Check for enough occupied cells
        if (occupied.size() < grid.getDimension()) {
            return false;
        }

        // Check for row win
        for (int current: xCoordSet) {
            if (occupied.stream().
                         filter(e -> e.getX() == current).
                         count() == grid.getDimension()) {
                return true;
            }
        }

        // Check for column win
        for (int current: yCoordSet) {
            if (occupied.stream().
                         filter(e -> e.getY() == current).
                         count() == grid.getDimension()) {
                return true;
            }
        }

        // Check for main diagonal win
        if (occupied.stream().
                filter(e -> e.getX() == e.getY()).
                count() == grid.getDimension()) {
            return true;
        }

        // Check for additional diagonal win
        if (occupied.stream().
                filter(e -> e.getX() == (grid.getDimension() - 1) - e.getY()).
                count() == grid.getDimension()) {
            return true;
        }

        // Otherwise - false
        return false;
    }

    /*
     * Adds cell to list of occupied,
     * cell's coords to xCoordSet and yCoordSet
     */
    private void addCellToOccupied(Cell cell) {
        // Adding cell to occupy
        this.occupied.add(cell);

        // Adding cell coords to sets
        this.xCoordSet.add(cell.getX());
        this.yCoordSet.add(cell.getY());
    }
}
