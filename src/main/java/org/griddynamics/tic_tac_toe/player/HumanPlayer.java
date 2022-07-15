package org.griddynamics.tic_tac_toe.player;

import org.griddynamics.tic_tac_toe.Cell;
import org.griddynamics.tic_tac_toe.Grid;
import org.griddynamics.tic_tac_toe.ui.HumanPlayerTUI;

/*
 * Represents human player
 */
public final class HumanPlayer extends Player {

    /*
     * Default constructor
     */
    public HumanPlayer(Grid grid, char sign) {
        super(grid, sign);
    }

    /*
     * Implementing selectCellToOccupy for HumanPlayer
     */
    @Override
    protected Cell selectFreeCell() {
        // While user does not select free cell
        int[] coords;
        while (true) {
            // Getting coords from user
            coords = HumanPlayerTUI.getCoordsFromUser();

            // Checking coords for being in bounds
            if (coords[0] >= getGrid().getDimension() || coords[1] >= getGrid().getDimension()) {
                HumanPlayerTUI.showCoordOutOfBoundError();
                continue;
            }

            // Checking for free
            if (this.getGrid().getCell(coords[0], coords[1]).getOccupantPlayer() == null) {
                // Success -> return
                return this.getGrid().getCell(coords[0], coords[1]);
            } else {
                // Failure -> show warning
                HumanPlayerTUI.showOccupiedCellCaptureWarning();
                continue;
            }
        }
    }
}
