package main.java.com.dius.bowling;
import java.util.*;

import static main.java.com.dius.bowling.Constants.*;

public class DiusBowlingGame implements BowlingGame {

    ArrayList<BowlingFrame> gameFrames = new ArrayList<BowlingFrame>();

    public void roll (int noOfPins) {

        doSpecialScoresForPreviousFrame(noOfPins);

        getCurrentFrame().frameScore += noOfPins;

        if (isFirstRollOfFrame()) {
            getCurrentFrame().roll1.pinsKnockedDown = noOfPins;
            getCurrentFrame().frameScore += noOfPins;
            // a strike can only occur on the 1st roll - we need to check if this is a strike
            getCurrentFrame().roll1.isStrike = this.isStrike(noOfPins);
            if (this.isStrike(noOfPins)) {
                advanceFrame();
            }
        }
        else {
            // this is the 2nd roll
            getCurrentFrame().roll2.pinsKnockedDown = noOfPins;
            // a spare can only occur on the 2nd roll - we need to check if this is a spare
            getCurrentFrame().roll2.isSpare = this.isSpare(noOfPins);

            advanceFrame();
        }
    }

    private void doSpecialScoresForPreviousFrame(int noOfPins) {
        if (gameFrames.size() > 1) { // there has been at least one previous frame
            // check if any additional score should be added to the previous frame
            // for a strike on the previous frame, increment that frame score by score of both rolls on the current frame
            // for a spare on the previous frame, increment that frame score by score of the 1st roll on the current frame
            if(
                    getPreviousFrame().roll1.isStrike ||
                    getPreviousFrame().roll2.isSpare && isFirstRollOfFrame()
            ) {
                getPreviousFrame().frameScore += noOfPins;
            }
        }
    }

    public BowlingFrame getCurrentFrame() {
        return gameFrames.get(gameFrames.size() - 1);
    }

    public BowlingFrame getPreviousFrame() {
        return gameFrames.get(gameFrames.size() - 2);
    }

    private boolean isFirstRollOfFrame() {
        return getCurrentFrame().roll1 == null;
    }

    private boolean isSpare(int noOfPins) {
        return getCurrentFrame().roll1.pinsKnockedDown + noOfPins == pinsPerFrame;
    }

    private boolean isStrike(int noOfPins) {
        return noOfPins == pinsPerFrame;
    }

    void advanceFrame() {
        if (gameFrames.size() < framesPerGame) {
            BowlingFrame newFrame = new BowlingFrame();
            gameFrames.add(newFrame);
        }
        else completeGame();
    }

    private void completeGame() {
        // TODO: do something to render the game complete
    }

    public int score() {
        int totalGameScore = 0;

        for (int i=0; i <= gameFrames.size(); i++) {
            totalGameScore += gameFrames.get(i).frameScore;
        }

        return totalGameScore;
    }

    public void simulateGame() {
        //Frame 1- strike
        roll(10);
        //Frame2
        roll(3);
        roll(0);
        //Frame3
        roll(0);
        roll(5);
        //Frame 4 - spare
        roll(4);
        roll(6);
        //Frame 5
        roll(2);
        roll(6);
        //Frame 6 - spare
        roll(5);
        roll(5);
        //Frame 6 - strike
        roll(10);
        //Frame 7 - strike
        roll(10);
        //Frame 8 - spare
        roll(2);
        roll(8);
        //Frame 9 -spare
        roll(0);
        roll(10);
        //Frame 10 - wipeout
        roll(0);
        roll(0);
    }
}
