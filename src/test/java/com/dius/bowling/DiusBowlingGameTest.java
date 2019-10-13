package test.java.com.dius.bowling;

import main.java.com.dius.bowling.BowlingGame;
import main.java.com.dius.bowling.DiusBowlingGame;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiusBowlingGameTest {

    private BowlingGame bowlingGame;

    @BeforeEach
    void setUp() {
        this.bowlingGame = new DiusBowlingGame();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void roll() {
    }

    @Test
    void score() {
    }

    @Test
    void firstRollShouldScoreThePinNumber() throws Exception {
        bowlingGame.roll(0);
        assertEquals(0, bowlingGame.score());

        bowlingGame.roll(1);
        assertEquals(1, bowlingGame.score());
    }
}