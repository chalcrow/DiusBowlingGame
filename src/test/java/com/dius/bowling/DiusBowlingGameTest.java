package com.dius.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiusBowlingGameTest {

    private DiusBowlingGame bowlingGame;

    @BeforeEach
    void setUp() {
        this.bowlingGame = new DiusBowlingGame();
        this.bowlingGame.startGame();
    }

    @Test
    void firstRollOfZeroShouldScoreZero() throws Exception {
        bowlingGame.roll(0);
        assertEquals(0, bowlingGame.score());
    }

    @Test
    void firstRollOfOneShouldScoreOne() throws Exception {
        bowlingGame.roll(1);
        assertEquals(1, bowlingGame.score());
    }

    @Test
    void frameOneFirstRollOfOneThenSecondRollOfEightShouldScoreNine() throws Exception {
        bowlingGame.roll(1);
        bowlingGame.roll(8);
        assertEquals(9, bowlingGame.score());
    }

    @Test
    void frameOneSpareThenFrameTwoFiveFourShouldScoreTwentyFour() throws Exception {
        bowlingGame.roll(1);
        bowlingGame.roll(9);
        bowlingGame.roll(5);
        bowlingGame.roll(4);
        assertEquals(24, bowlingGame.score());
    }

    @Test
    void frameOneSpareThenFrameTwoStrikeShouldScoreThirty() throws Exception {
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(10);
        assertEquals(30, bowlingGame.score());
    }

    @Test
    void frameOneStrikeThenFrameTwoSixThreeShouldScoreTwentyEight() throws Exception {
        bowlingGame.roll(10);
        bowlingGame.roll(6);
        bowlingGame.roll(3);
        assertEquals(28, bowlingGame.score());
    }
}