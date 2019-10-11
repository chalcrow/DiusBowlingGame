package main.java.com.dius.bowling;
import java.util.*;

public class DiusBowlingGame implements BowlingGame {

    final int pinsPerFrame = 10;
    public int totalScore = 0;

    ArrayList<BowlingFrame> gameFrames = new ArrayList<BowlingFrame>();

    public void roll (int noOfPins) {

        if (getCurrentFrame().rollNumberInFrame == 1) {
            // a strike can only occur on the 1st roll - we need to check if this is a strike
            if (isStrike(noOfPins)) {
                getCurrentFrame().isStrike = this.isStrike(noOfPins);
                advanceFrame();
            }
        }
        else {
            // this is the 2nd roll
            // a spare can only occur on the 2nd roll - we need to check if this is a spare
            if(isSpare(noOfPins)) {

            }
            advanceFrame();
        }

        advanceRollNumber();
        totalScore += noOfPins;
    }

    private void advanceRollNumber() {
        if ((getCurrentFrame().rollNumberInFrame == 1)) {
            getCurrentFrame().rollNumberInFrame = 2;
        } else {
            advanceFrame();
        }
    }

    private boolean isSpare(int noOfPins) {
        return getCurrentFrame().firstRollPins + noOfPins == pinsPerFrame;
    }

    private boolean isStrike(int noOfPins) {
        return noOfPins == pinsPerFrame;
    }

    public BowlingFrame getCurrentFrame() {
        return this.gameFrames.get(this.gameFrames.size() - 1);
    }

    private void advanceFrame() {
        if (gameFrames.size() < 10) {
            BowlingFrame newFrame = new BowlingFrame();
            newFrame.rollNumberInFrame = 1;
            gameFrames.add(newFrame);
        }
        else completeGame();
    }

    private void completeGame() {
        // TODO: do something to render the game complete
    }



    public int score () {

        return totalScore;
    }
}
