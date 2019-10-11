package main.java.com.dius.bowling;
import java.util.*;

public class DiusBowlingGame implements BowlingGame {

    public int totalScore = 0;
    public int totalFramesPlayed = 0;
    public boolean isStrike = false;

    public int currentFrame = 0;
    public int rollNumberWithinFrame = 0;
    public int[][] frameScores = new int[10][2];

    public void roll (int noOfPins) {

        if(noOfPins == 10) {
            isStrike = true;
            currentFrame += 1;
        }

        totalScore += noOfPins;
    }

    public int score () {

        return totalScore;
    }
}
