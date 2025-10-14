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

    @Test
    public void testPlayerAScores2AndPlayerBScores1DifferentOrderScore30_15() {
        TennisScorer scorer = new TennisScorer();
        scorer.winningPoint('A');
        scorer.winningPoint('A');
        scorer.winningPoint('B');
        assertEquals("30:15", scorer.currentScore());
    }

    @Test
    public void testPlayerAScores2AndPlayerBScores2DifferentOrderScore30_30() {
        TennisScorer scorer = new TennisScorer();
        scorer.winningPoint('A');
        scorer.winningPoint('A');
        scorer.winningPoint('B');
        scorer.winningPoint('B');
        assertEquals("30:30", scorer.currentScore());
    }

    @Test
    public void testPlayerAScores3AndPlayerBScores2DifferentOrderScore40_30() {
        TennisScorer scorer = new TennisScorer();
        scorer.winningPoint('A');
        scorer.winningPoint('A');
        scorer.winningPoint('B');
        scorer.winningPoint('B');
        scorer.winningPoint('A');
        assertEquals("40:30", scorer.currentScore());
    }

    @Test
    public void testPlayerAScores2AndPlayerBScores3DifferentOrderScore30_40() {
        TennisScorer scorer = new TennisScorer();
        scorer.winningPoint('A');
        scorer.winningPoint('B');
        scorer.winningPoint('B');
        scorer.winningPoint('B');
        scorer.winningPoint('A');
        assertEquals("30:40", scorer.currentScore());
    }

    @Test
    public void testPlayerAScores4AndPlayerBScores3DifferentOrderScore30_40() {
        TennisScorer scorer = new TennisScorer();
        scorer.winningPoint('A');
        scorer.winningPoint('B');
        scorer.winningPoint('B');
        scorer.winningPoint('B');
        scorer.winningPoint('A');
        scorer.winningPoint('A');
        scorer.winningPoint('A');
        assertEquals("Adv:40", scorer.currentScore());
    }

    @Test
    public void testAdvantageGoesAwayScore40_40() {
        TennisScorer scorer = new TennisScorer();
        scorer.winningPoints("AAABBBBA");
        assertEquals("40:40", scorer.currentScore());
    }

    @Test
    public void testPlayer1WinsGameNoAdv() {
        TennisScorer scorer = new TennisScorer();
        scorer.winningPoints("AAABBA");
        assertEquals("1-0 0:0", scorer.currentScore());
    }

    @Test
    public void testPlayer1WinsGameWithAdv() {
        TennisScorer scorer = new TennisScorer();
        scorer.winningPoints("AAABBBABABAA");
        assertEquals("1-0 0:0", scorer.currentScore());
    }

    @Test
    public void testPlayer1WinsGameThenBScores3() {
        TennisScorer scorer = new TennisScorer();
        scorer.winningPoints("AAABBABBB");
        assertEquals("1-0 0:40", scorer.currentScore());
    }

    @Test
    public void testPlayer1Wins6GamesSoSetWon() {
        TennisScorer scorer = new TennisScorer();
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        assertEquals("6-0 0:0", scorer.currentScore());
    }
}