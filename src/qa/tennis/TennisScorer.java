package qa.tennis;

public class TennisScorer {
	private Score score;
	private String previousString;
    private static final String[] scores = {"0", "15", "30", "40", "Adv"};
    private static final int LOVE = 0;
    private static final int FORTY = 3;
    private static final int ADVANTAGE = 4;
    private int playerAGames;
    private int playerBGames;
    private int playerA;
    private int playerB;
	
	public TennisScorer() {
		score = new Score();
		previousString = "";

        // Initialise params
        playerA = LOVE;
        playerB = LOVE;
        playerAGames = 0;
        playerBGames = 0;
	}
	
	public void winningPoint(char player) {
		winningPoints(String.valueOf(player));
	}
	
	public void winningPoints(String players) {
		previousString += players;
	}


	public String currentScore() {
        char[] winningSequence = previousString.toCharArray();
        for (char winner : winningSequence) {
            switch (winner) {
                case 'A':
                    // Player A wins point
                    // Nothing special for scores of 15 30 and 40
                    playerA++;
                    if (playerA == ADVANTAGE) {
                        if (playerB == ADVANTAGE) {
                            // Reset to deuce
                            playerA = playerB = FORTY;
                        } else if (playerB < FORTY) {
                            playerWonGame('A');
                        }
                        break;
                    } else if (playerA > ADVANTAGE) {
                        playerWonGame('A');
                        break;
                    } else {
                        break;
                    }
                case 'B':
                    // Player B wins point
                    // Nothing special for scores of 15 30 and 40
                    playerB++;
                    if (playerB == ADVANTAGE) {
                        if (playerA == ADVANTAGE) {
                            // Reset to deuce
                            playerA = playerB = FORTY;
                        } else if (playerA < FORTY) {
                            playerWonGame('B');
                        }
                        break;
                    } else if (playerB > ADVANTAGE) {
                        playerWonGame('B');
                        break;
                    } else {
                        break;
                    }
            }
        }

        if (playerAGames > 0 || playerBGames > 0) {
            // Set score of current set
            score.setPlayerAgames(playerAGames);
            score.setPlayerBgames(playerBGames);
        }

        // Set score of current game
        score.setPlayerAgameScore(scores[playerA]);
        score.setPlayerBgameScore(scores[playerB]);

		return score.toString();
	}

	public Score getScore() {
		return score;
	}
	
	private void playerWonSet() {
        // Set score of current set
        score.setPlayerAgames(playerAGames);
        score.setPlayerBgames(playerBGames);
        score.nextSet();
        playerAGames = playerBGames = 0;
    }

    private void playerWonGame(char winningPlayer) {
        // player has won the game
        if (winningPlayer == 'A') {
            playerAGames++;

            // Player A wins set
            if (playerAGames == 6) {
                if (playerBGames < 5) {
                    playerWonSet();
                }
            } else if (playerAGames == 7) {
                playerWonSet();
            }
        } else {
            playerBGames++;

            // Player B wins set
            if (playerBGames == 6) {
                if (playerAGames < 5) {
                    playerWonSet();
                }
            } else if (playerBGames == 7) {
                playerWonSet();
            }
        }

        // Reset score to 0:0
        playerA = playerB = LOVE;
    }
}
