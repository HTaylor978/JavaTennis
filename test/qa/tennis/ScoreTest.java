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

    @Test
    public void testBothPlayersScore1PointScore15_15() {
        TennisScorer scorer = new TennisScorer();
        scorer.winningPoint('A');
        scorer.winningPoint('B');
        assertEquals("15:15", scorer.currentScore());
    }

    @Test
    public void testPlayerAScores2AndPlayerBScores1Score30_15() {
        TennisScorer scorer = new TennisScorer();
        scorer.winningPoint('A');
        scorer.winningPoint('B');
        scorer.winningPoint('A');
        assertEquals("30:15", scorer.currentScore());
    }
}