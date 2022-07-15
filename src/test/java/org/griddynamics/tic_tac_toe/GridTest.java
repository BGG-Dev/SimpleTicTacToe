package org.griddynamics.tic_tac_toe;

import org.griddynamics.tic_tac_toe.ui.GridCellGameTUI;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/*
 * Grid class tests
 */
public class GridTest {

    @Test
    void gridCreationTest() {
        // Creating new grid
        Grid g = new Grid(3);

        // Printing grid
        GridCellGameTUI.gridHumanStringRepresentation(g);

        // Asserting
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertNull(g.getCell(i, j).getOccupantPlayer());
                assertEquals(g.getCell(i, j).getGrid(), g);
                assertEquals(g.getCell(i, j).getX(), i);
                assertEquals(g.getCell(i, j).getY(), j);
            }
        }
        assertEquals(g.getDimension(), 3);
    }
}
