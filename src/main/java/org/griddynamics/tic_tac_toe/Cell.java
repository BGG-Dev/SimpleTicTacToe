package org.griddynamics.tic_tac_toe;

import org.griddynamics.tic_tac_toe.player.Player;

public final class Cell {

    // Game grid
    private final Grid grid;

    // Occupied player
    private Player occupantPlayer;

    // Private coordinates
    private final int x, y;

    /*
     * Default cell constructor
     */
    Cell(Grid grid, int x, int y) {
        this.grid = grid;
        this.x = x;
        this.y = y;
        this.occupantPlayer = null;
    }

    /*
     * Grid getter
     */
    public Grid getGrid() {
        return this.grid;
    }

    /*
     * master getter
     */
    public Player getOccupantPlayer() {
        return this.occupantPlayer;
    }

    /*
     * x getter
     */
    public int getX() {
        return this.x;
    }

    /*
     * y getter
     */
    public int getY() {
        return this.y;
    }

    /*
     * Occupies cell by player
     */
    public boolean occupyByPlayer(Player player) {
        // Check if already occupied
        if (this.occupantPlayer != null) {
            return false;
        }

        // Not occupied -> assign, return true
        this.occupantPlayer = player;

        // Reducing grid's free cell count
        this.grid.reduceFreeCellCount();

        // Returning true
        return true;
    }
}
