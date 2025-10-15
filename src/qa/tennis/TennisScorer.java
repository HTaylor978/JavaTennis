package qa.tennis;

public class TennisScorer {
	private Score score;
	private String previousString;
    private static final String[] scores = {"0", "15", "30", "40", "Adv"};
    private static final int LOVE = 0;
    private static final int FORTY = 3;
    private static final int ADVANTAGE = 4;
	
	public TennisScorer() {
		score = new Score();
		previousString = "";
	}
	
	public void winningPoint(char player) {
		winningPoints(String.valueOf(player));
	}
	
	public void winningPoints(String players) {
		previousString += players;
	}


	public String currentScore() {

        int playerA = LOVE,  playerB = LOVE;
        int playerAGames = 0, playerBGames = 0;
//        String set = "";

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
                        } else {
                            // playerA has won the game
                            // Reset score to 0:0
                            playerAGames++;
                            playerA = playerB = LOVE;
                        }
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
                        } else {
                            // playerB has won the game
                            // Reset score to 0:0
                            playerBGames++;
                            playerA = playerB = LOVE;
                        }
                        break;
                    } else {
                        break;
                    }
            }
        }
//                case 'B':
//                    switch (playerB) {
//                        case "0":
//                            playerB = scores[1]; //15
//                            break;
//                        case "15":
//                            playerB = scores[2]; //30
//                            break;
//                        case "30":
//                            playerB = scores[3]; //40
//                            break;
//                        case "40":
//                            if (playerA.equals("40")) {
//                                playerB = scores[4]; //Adv
//                            } else if (playerA.equals("Adv")) {
//                                playerA = scores[3]; // A back to 40
//                            } else {
//                                playerA = playerB = scores[0];
//                                playerBSets += 1;
//                                if (playerBSets == 6) {
//                                    if (playerASets < 5) {
//                                        set += formatSet(playerASets, playerBSets);
//                                        playerASets = playerBSets = 0;
//                                    }
//                                } else if (playerBSets == 7) {
//                                    set += formatSet(playerASets, playerBSets);
//                                    playerASets = playerBSets = 0;
//                                }
//                            }
//                            break;
//                        case "Adv":
//                            playerA = playerB = scores[0];
//                            playerBSets += 1;
//                            if (playerBSets == 6) {
//                                if (playerASets < 5) {
//                                    set += formatSet(playerASets, playerBSets);
//                                    playerASets = playerBSets = 0;
//                                }
//                            } else if (playerBSets == 7) {
//                                set += formatSet(playerASets, playerBSets);
//                                playerASets = playerBSets = 0;
//                            }
//                            break;
//                    }
//                    break;
//            }
//        }

        // Format set

        //set += formatSet(playerASets, playerBSets);

        // Set score of current set
        score.setPlayerAgames(playerAGames);
        score.setPlayerBgames(playerBGames);

        // Set score of current game
        score.setPlayerAgameScore(scores[playerA]);
        score.setPlayerBgameScore(scores[playerB]);

		return score.toString();
	}

	public Score getScore() {
		return score;
	}
	
	private String formatSet(int playerASets, int playerBSets) {
        String set = "";
        if (playerASets != 0 || playerBSets != 0) {
            set = Integer.toString(playerASets) + "-" + Integer.toString(playerBSets) + " ";
        }
        return set;
    }

}
