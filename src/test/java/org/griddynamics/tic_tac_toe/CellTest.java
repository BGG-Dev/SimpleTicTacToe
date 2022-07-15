package org.griddynamics.tic_tac_toe;

import org.griddynamics.tic_tac_toe.player.HumanPlayer;

import org.griddynamics.tic_tac_toe.ui.GridCellGameTUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Cell class tests
 */
class CellTest {

    @Test
    void cellSignleOccupationTest() {
        // Greetings
        System.out.println("========== Sigle occupation ==========");

        // Grid creation
        Grid g = new Grid(4);

        // Creating new human player
        HumanPlayer hp1 = new HumanPlayer(g, 'X');

        // Occupying
        boolean occupationResult = g.getCell(0, 1).occupyByPlayer(hp1);

        // Printing grid
        System.out.println("Grid (after occupation):");
        GridCellGameTUI.gridHumanStringRepresentation(g);

        // Asserting
        assertTrue(occupationResult);
        assertEquals(g.getCell(0, 1).getOccupantPlayer(), hp1);
    }

    @Test
    void cellMultipleOccupationTest() {
        // Greetings
        System.out.println("========== Multiple occupation ==========");

        // Grid creation
        Grid g = new Grid(4);

        // Creating new human player
        HumanPlayer hp1 = new HumanPlayer(g, 'X');

        // Occupying
        boolean occupationResult = g.getCell(2, 1).occupyByPlayer(hp1);

        // Printing grid
        System.out.println("Grid (after occupation):");
        GridCellGameTUI.gridHumanStringRepresentation(g);

        // Asserting
        assertTrue(occupationResult);
        assertEquals(g.getCell(2, 1).getOccupantPlayer(), hp1);

        // Creating another human player
        HumanPlayer hp2 = new HumanPlayer(g, 'O');

        // Trying to occupy [2, 1] with hp2
        occupationResult = g.getCell(2, 1).occupyByPlayer(hp2);

        // Printing grid
        System.out.println("Grid (2nd failed occupation attempt):");
        GridCellGameTUI.gridHumanStringRepresentation(g);

        // Asserting
        assertFalse(occupationResult);
        assertEquals(g.getCell(2, 1).getOccupantPlayer(), hp1);

        // Final occupation
        occupationResult = g.getCell(3, 3).occupyByPlayer(hp2);

        // Printing grid
        System.out.println("Grid (final):");
        GridCellGameTUI.gridHumanStringRepresentation(g);

        // Asserting
        assertTrue(occupationResult);
        assertEquals(g.getCell(3, 3).getOccupantPlayer(), hp2);
        assertEquals(g.getCell(2, 1).getOccupantPlayer(), hp1);
    }
}
