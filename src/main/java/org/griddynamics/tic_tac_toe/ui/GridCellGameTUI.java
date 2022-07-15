package org.griddynamics.tic_tac_toe.ui;

import org.griddynamics.tic_tac_toe.Cell;
import org.griddynamics.tic_tac_toe.Grid;
import org.griddynamics.tic_tac_toe.player.Player;

import java.util.Scanner;

/*
 * TUI for Cell and Grid classes
 */
public final class GridCellGameTUI {

    // Scanner for stdin
    private static final Scanner scanIn = new Scanner(System.in);

    // String to represent free cell on grid
    private static final String CELL_FREE_SIGN = "_";

    // Upper-lower grid border part
    private static final String GRID_UPPER_LOWER_BORDER_PART = "---";

    // Left grid border part
    private static final String GRID_LEFT_BORDER_PART ="\n|";

    // Right grid border part
    private static final String GRID_RIGHT_BORDER_PART =" |";

    /*
     * cell instance human string representation
     */
    private static String cellHumanStringRepresentation(Cell cell) {
        // Creating representation
        String signStr = cell.getOccupantPlayer() == null ?
                CELL_FREE_SIGN : Character.toString(cell.getOccupantPlayer().getSign());

        // Saving in result
        return " " + signStr;
    }

    /*
     * grid instance human string representation
     */
    public static void gridHumanStringRepresentation(Grid grid) {
        // Creating actual upper-lower grid border
        String gridUpperLowerBorder = GRID_UPPER_LOWER_BORDER_PART.repeat(grid.getDimension());

        // Creating string builder
        StringBuilder sb = new StringBuilder();

        // Adding upper border
        sb.append(gridUpperLowerBorder);

        // Adding cells
        for (int i = 0; i < grid.getDimension(); i++) {
            // Adding left border
            sb.append(GRID_LEFT_BORDER_PART);

            // Adding current row cells
            for (int j = 0; j < grid.getDimension(); j++) {
                sb.append(cellHumanStringRepresentation(grid.getCell(i, j)));
            }

            // Adding right border
            sb.append(GRID_RIGHT_BORDER_PART);
        }

        // Adding lower border
        sb.append('\n');
        sb.append(gridUpperLowerBorder);

        // Printing
        System.out.println(sb.toString());
    }

    /*
     * Returns win end string
     */
    public static void winEnd(Player winner) {
        System.out.println(winner.getSign() + " wins");
    }

    /*
     * Returns draw end string
     */
    public static void drawEnd() {
        System.out.println("draw");
    }
}
