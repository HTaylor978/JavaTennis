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
    public void testPlayerAWinsGameNoAdv() {
        TennisScorer scorer = new TennisScorer();
        scorer.winningPoints("AAABBA");
        assertEquals("1-0 0:0", scorer.currentScore());
    }

    @Test
    public void testPlayerAWinsGameWithAdv() {
        TennisScorer scorer = new TennisScorer();
        scorer.winningPoints("AAABBBABABAA");
        assertEquals("1-0 0:0", scorer.currentScore());
    }

    @Test
    public void testPlayerAWinsGameThenBScores3() {
        TennisScorer scorer = new TennisScorer();
        scorer.winningPoints("AAABBABBB");
        assertEquals("1-0 0:40", scorer.currentScore());
    }

    @Test
    public void testPlayerAWins6GamesSoSetWon() {
        TennisScorer scorer = new TennisScorer();
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        assertEquals("6-0 0:0", scorer.currentScore());
    }

    @Test
    public void testPlayerAWins7GamesSoSetWonAndSetScore1_0() {
        TennisScorer scorer = new TennisScorer();
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        assertEquals("6-0 1-0 0:0", scorer.currentScore());
    }

    @Test
    public void testPlayerAWins4PlayerBWins5GamesSetScore4_5ThenAScoresAdv() {
        TennisScorer scorer = new TennisScorer();
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AABBBB");
        scorer.winningPoints("AABBBB");
        scorer.winningPoints("AABBBB");
        scorer.winningPoints("AABBBB");
        scorer.winningPoints("AABBBB");
        scorer.winningPoints("AAABBBA");
        assertEquals("4-5 Adv:40", scorer.currentScore());
    }

    @Test
    public void testPlayerAWins3SetsPlayerBWins2() {
        TennisScorer scorer = new TennisScorer();
        // Set 1
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AABBBB");
        scorer.winningPoints("AABBBB");
        scorer.winningPoints("AABBBB");
        scorer.winningPoints("AABBBB");
        scorer.winningPoints("AABBBB");
        scorer.winningPoints("ABBBB");

        // Set 2
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AAABBA");
        scorer.winningPoints("AABBBB");
        scorer.winningPoints("AABBBB");
        scorer.winningPoints("AABBBB");
        scorer.winningPoints("AABBBB");
        scorer.winningPoints("AABBBB");
        scorer.winningPoints("AAABBBA");
        assertEquals("4-6 3-5 Adv:40", scorer.currentScore());
    }

    @Test
    public void testTiebreakPlayerAWinsSetScore7_5() {
        TennisScorer scorer = new TennisScorer();
        // Set 1
        scorer.winningPoints("AAABBA"); // 1-0
        scorer.winningPoints("AAABBA"); // 2-0
        scorer.winningPoints("AAABBA"); // 3-0
        scorer.winningPoints("AAABBA"); // 4-0
        scorer.winningPoints("AABBBB"); // 4-1
        scorer.winningPoints("AABBBB"); // 4-2
        scorer.winningPoints("AABBBB"); // 4-3
        scorer.winningPoints("AABBBB"); // 4-4
        scorer.winningPoints("AABBBB"); // 4-5
        scorer.winningPoints("AAAA"); // 5-5
        scorer.winningPoints("AAAA"); // 6-5
        scorer.winningPoints("AAAA"); // 7-5
        assertEquals("7-5 0:0", scorer.currentScore());
    }

    @Test
    public void testTiebreakPlayerBWinsSetScore6_7() {
        TennisScorer scorer = new TennisScorer();
        // Set 1
        scorer.winningPoints("AAABBA"); // 1-0
        scorer.winningPoints("AAABBA"); // 2-0
        scorer.winningPoints("AAABBA"); // 3-0
        scorer.winningPoints("AAABBA"); // 4-0
        scorer.winningPoints("AABBBB"); // 4-1
        scorer.winningPoints("AABBBB"); // 4-2
        scorer.winningPoints("AABBBB"); // 4-3
        scorer.winningPoints("AABBBB"); // 4-4
        scorer.winningPoints("AABBBB"); // 4-5
        scorer.winningPoints("AAAA"); // 5-5
        scorer.winningPoints("AAAA"); // 6-5
        scorer.winningPoints("BBBB"); // 6-6
        scorer.winningPoints("BBBB"); // 6-7
        assertEquals("6-7 0:0", scorer.currentScore());
    }
}