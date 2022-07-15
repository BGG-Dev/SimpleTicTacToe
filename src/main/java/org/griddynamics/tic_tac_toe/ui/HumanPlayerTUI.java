package org.griddynamics.tic_tac_toe.ui;

import java.util.Arrays;
import java.util.Scanner;

/*
 * TUI for HumanPlayer
 */
public final class HumanPlayerTUI {

    // Scanner for stdin
    private static final Scanner scanIn = new Scanner(System.in);

    // Regex to get coords from user
    private static final String COORDS_REGEX = "[0123456789]+ [0123456789]+";

    /*
     * Gets cell coordinates from player
     */
    public static int[] getCoordsFromUser() {
        String buff;
        while (true) {
            // Printing message
            System.out.println("Enter coords | x y:");

            // Getting input
            buff = scanIn.nextLine();

            // Checking for regex
            if (buff.matches(COORDS_REGEX)) {
                return Arrays.stream(buff.split(" ")).mapToInt(Integer::parseInt).toArray();
            } else {
                System.out.println("Wrong input format");
            }
        }
    }

    /*
     * Shows coord out of bound error
     */
    public static void showCoordOutOfBoundError() {
        System.out.println("Coords are out of grid dimension");
    }

    /*
     * Shows occupied cell warning
     */
    public static void showOccupiedCellCaptureWarning() {
        System.out.println("The cell has already been taken by other player");
    }
}
