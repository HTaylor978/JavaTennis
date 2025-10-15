package qa.tennis;

public class TennisScorer {
	private Score score;
	private String previousString;
    private static final String[] scores = {"0", "15", "30", "40", "Adv"};
	
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

        String playerA = scores[0],  playerB = scores[0];
        int playerASets = 0, playerBSets = 0;
        String set = "";

        char[] winningSequence = previousString.toCharArray();
        for (char winner : winningSequence) {
            switch (winner) {
                case 'A':
                    switch (playerA) {
                        case "0":
                            playerA = scores[1]; //15
                            break;
                        case "15":
                            playerA = scores[2]; //30
                            break;
                        case "30":
                            playerA = scores[3]; //40
                            break;
                        case "40":
                            if (playerB.equals("40")) {
                                playerA = scores[4]; // Adv
                            } else if (playerB.equals("Adv")) {
                                playerB = scores[3]; // B back to 40
                            } else {
                                playerA = playerB = scores[0]; // Win
                                playerASets += 1;
                                if (playerASets == 6) {
                                    if (playerBSets < 5) {
                                        set += formatSet(playerASets, playerBSets);
                                        playerASets = playerBSets = 0;
                                    }
                                } else if (playerASets == 7) {
                                    set += formatSet(playerASets, playerBSets);
                                    playerASets = playerBSets = 0;
                                }
                            }
                            break;
                        case "Adv":
                            playerA = playerB = scores[0]; // Win
                            playerASets += 1;
                            if (playerASets == 6) {
                                if (playerBSets < 5) {
                                    set += formatSet(playerASets, playerBSets);
                                    playerASets = playerBSets = 0;
                                }
                            } else if (playerASets == 7) {
                                set += formatSet(playerASets, playerBSets);
                                playerASets = playerBSets = 0;
                            }
                            break;
                    }
                    break;
                case 'B':
                    switch (playerB) {
                        case "0":
                            playerB = scores[1]; //15
                            break;
                        case "15":
                            playerB = scores[2]; //30
                            break;
                        case "30":
                            playerB = scores[3]; //40
                            break;
                        case "40":
                            if (playerA.equals("40")) {
                                playerB = scores[4]; //Adv
                            } else if (playerA.equals("Adv")) {
                                playerA = scores[3]; // A back to 40
                            } else {
                                playerA = playerB = scores[0];
                                playerBSets += 1;
                                if (playerBSets == 6) {
                                    if (playerASets < 5) {
                                        set += formatSet(playerASets, playerBSets);
                                        playerASets = playerBSets = 0;
                                    }
                                } else if (playerBSets == 7) {
                                    set += formatSet(playerASets, playerBSets);
                                    playerASets = playerBSets = 0;
                                }
                            }
                            break;
                        case "Adv":
                            playerA = playerB = scores[0];
                            playerBSets += 1;
                            if (playerBSets == 6) {
                                if (playerASets < 5) {
                                    set += formatSet(playerASets, playerBSets);
                                    playerASets = playerBSets = 0;
                                }
                            } else if (playerBSets == 7) {
                                set += formatSet(playerASets, playerBSets);
                                playerASets = playerBSets = 0;
                            }
                            break;
                    }
                    break;
            }
        }

        // Format set

        set += formatSet(playerASets, playerBSets);

		return set + playerA + ":" + playerB;
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
