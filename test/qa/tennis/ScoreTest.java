package qa.tennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    public void testNewTennisScoreReturns0_0() {
        TennisScorer scorer = new TennisScorer();
        assertEquals("0:0", scorer.currentScore());
    }

    @Test
    public void testPlayerAScores1PointScore15_0() {
        TennisScorer scorer = new TennisScorer();
        scorer.winningPoint('A');
        assertEquals("15:0", scorer.currentScore());
    }
}