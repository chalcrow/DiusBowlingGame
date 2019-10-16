package com.dius.bowling;

/**
 * Interface for a bowling game.
 */
public interface BowlingGame {
    /**
     * roll method specifying how many pins have been knocked down
     * @param noOfPins no. of pins knocked down
     */
    void roll(int noOfPins);

    /**
     * get player's current score
     * @return player's current score
     */
    int score();
}