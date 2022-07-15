package org.griddynamics;

import org.griddynamics.tic_tac_toe.Game;

/*
 * Program entrance class
 */
public class Main {

    /*
     * Program entrance method
     */
    public static void main(String[] args) {
        // Creating game
        Game tictactoe = Game.create2Human();

        // Running
        tictactoe.run();
    }
}