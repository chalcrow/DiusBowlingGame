package com.dius.bowling;

public class Main {

    private DiusBowlingGame game;

    public static void main(String[] args) {
        // method to perform rolls and calculate totalscore
        DiusBowlingGame game = new DiusBowlingGame();
        // for a new game, we must advance to the 1st frame
        game.startGame();
        game.simulateGame();
    }
}
